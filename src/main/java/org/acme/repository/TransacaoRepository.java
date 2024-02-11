package org.acme.repository;


import org.acme.entity.Transacao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterForReflection
public class TransacaoRepository implements PanacheRepository<Transacao>{

    
}
