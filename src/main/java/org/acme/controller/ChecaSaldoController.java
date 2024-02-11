package org.acme.controller;


import java.util.List;

import org.acme.entity.ChecaSaldo;
import org.acme.service.ChecaSaldoService;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/clientes")
public class ChecaSaldoController {

    @Inject
    ChecaSaldoService service;

    @GET
    @Path("/checa-saldo")
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public List<ChecaSaldo> obterDados() {
        return service.obterDados();
    }

    
}
