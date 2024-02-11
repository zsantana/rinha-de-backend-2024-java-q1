package org.acme.service;

import java.util.Collections;
import java.util.stream.Collectors;

import org.acme.dto.ExtratoDTO;
import org.acme.dto.SaldoDTO;
import org.acme.dto.TransacaoResponseDTO;
import org.acme.repository.ClienteRepository;
import org.acme.repository.SaldoClienteRepository;
import org.acme.repository.TransacaoRepository;
import org.jboss.logging.Logger;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
@RegisterForReflection
public class ExtratoService {

    private static final Logger logger = Logger.getLogger(TransacaoService.class);

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    TransacaoRepository transacaoRepository;

    @Inject
    SaldoClienteRepository saldoClienteRepository;

    public ExtratoDTO obterExtrato(final Long id) {

        var cliente = clienteRepository.findById(id);

        if (cliente == null) throw new WebApplicationException("Registro não encontrado para o cliente com ID: " + id, 404);

        var ultimasTransacoes = transacaoRepository.find("cliente.id = ?1 order by id desc", id)
                                                    .page(0, 10)
                                                    .list();

        var saldoAtual =  saldoClienteRepository.find("cliente.id = ?1" , id).firstResult() ;                                        
                                                    
        if (ultimasTransacoes.isEmpty()) {
            logger.error("Não existe transacao para o ID informa:" + id);
            var saldo = new SaldoDTO(null, 0, cliente.limite);
            return new ExtratoDTO (saldo , Collections.emptyList());
        }
        
        var saldo = new SaldoDTO(ultimasTransacoes.get(0).realizada_em, saldoAtual.valor, ultimasTransacoes.get(0).cliente.limite);
        var ultimasTransacoesDTO = ultimasTransacoes
                                        .stream()
                                        .map(t -> new TransacaoResponseDTO(t.valor, t.tipo.toString(), t.descricao, t.realizada_em))
                                        .collect(Collectors.toList());

        return new ExtratoDTO (saldo , ultimasTransacoesDTO);


    }

    
}
