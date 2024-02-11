package org.acme.controller;

import org.acme.dto.ExtratoDTO;
import org.acme.dto.LimiteSaldoDTO;
import org.acme.dto.TransacaoRequestDTO;
import org.acme.service.ExtratoService;
import org.acme.service.TransacaoService;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/clientes")
public class ClientesController {

    @Inject
    TransacaoService transacaoService;

    @Inject
    ExtratoService extratoService;

    @POST
    @Path("/{id}/transacoes")
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public LimiteSaldoDTO processarTransacao(@PathParam("id") @Min(value = 1, message = "ID deve ser um número positivo") Long id, @Valid TransacaoRequestDTO dto) {
        return transacaoService.processarTransacao(id, dto);
    }



    @GET
    @Path("/{id}/extrato")
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public ExtratoDTO extrato(@PathParam("id") @Min(value = 1, message = "ID deve ser um número positivo") Long id) {
        return extratoService.obterExtrato(id);
    }

    
}
