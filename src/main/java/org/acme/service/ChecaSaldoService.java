package org.acme.service;

import java.util.List;

import org.acme.entity.ChecaSaldo;
import org.acme.repository.ChecaSaldoRepository;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
@RegisterForReflection
public class ChecaSaldoService {

    @Inject
    ChecaSaldoRepository checaSaldoRepository;

    public List<ChecaSaldo> obterDados() {
        return checaSaldoRepository.listAll();
    }
    
}
