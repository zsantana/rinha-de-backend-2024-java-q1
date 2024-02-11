package org.acme.service;


import java.time.LocalDateTime;

import org.acme.dto.LimiteSaldoDTO;
import org.acme.dto.TransacaoRequestDTO;
import org.acme.entity.Cliente;
import org.acme.entity.SaldoCliente;
import org.acme.entity.Transacao;
import org.jboss.logging.Logger;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
@RegisterForReflection
public class TransacaoService {

    private static final Logger logger = Logger.getLogger(TransacaoService.class);

    @Transactional
    public LimiteSaldoDTO processarTransacao(Long id, TransacaoRequestDTO dto) {

        if (!dto.ehValida()) throw new WebApplicationException("Dados invalidos ", 422);

        var transacao = criarTransacao(id, dto);
        var saldoCliente = atualizarSaldo(transacao);

        return new LimiteSaldoDTO(saldoCliente.valor, saldoCliente.cliente.limite);

    }

    private SaldoCliente atualizarSaldo(Transacao transacao) {

        int valor = transacao.valor;
        SaldoCliente saldoCliente = SaldoCliente.findById(transacao.cliente.id, LockModeType.PESSIMISTIC_WRITE);

        if (saldoCliente == null) {
            throw new WebApplicationException("Registro não encontrado para o cliente com ID: " + transacao.cliente.id, 404);
        }

        if (transacao.tipo == 'c') {
            saldoCliente.valor = (saldoCliente.valor + valor);
        } else {
            int novoSaldo = saldoCliente.valor - valor;
            
            if ((novoSaldo + saldoCliente.cliente.limite) < 0) {
                logger.error("### Saldo negativo para id: " + transacao.cliente.id );
                logger.error("### Limite: " + saldoCliente.cliente.limite);
                logger.error("### Valor da transacao: " +  valor);
                throw new WebApplicationException("Transação não permitida. Saldo negativo excede limite.", 422);
            }
            
            saldoCliente.valor = (novoSaldo);
        }

        saldoCliente.persist();

        return saldoCliente;
    }


    private Transacao criarTransacao(Long id, TransacaoRequestDTO dto) {

        var transacao = new Transacao();

        var cliente = new Cliente();
        cliente.id = id;

        transacao.cliente = cliente;
        transacao.tipo = dto.tipo().charAt(0);
        transacao.descricao = dto.descricao();
        transacao.realizada_em = LocalDateTime.now();
        transacao.valor = Integer.parseInt(dto.valor());

        transacao.persist();

        return transacao;
    }

}
