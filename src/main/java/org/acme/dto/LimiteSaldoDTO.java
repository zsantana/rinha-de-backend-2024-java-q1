package org.acme.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class LimiteSaldoDTO {

    public Integer limite;
    public Integer saldo;

    public LimiteSaldoDTO(Integer saldo) {
        this.saldo = saldo;
    }

    public LimiteSaldoDTO(Integer saldo, Integer limite) {
        this.limite = limite;
        this.saldo = saldo;
    }

}
