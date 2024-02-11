package org.acme.repository;


import org.acme.entity.ChecaSaldo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterForReflection
public class ChecaSaldoRepository implements PanacheRepository<ChecaSaldo>{

    
}
