package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;

@Entity
@Table(name = "v_checa_saldo_cliente")
@Cacheable
@RegisterForReflection
public class ChecaSaldo extends PanacheEntityBase {
    

    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "limite")
    public Integer limite;

    @Column(name = "saldo_atual")
    public Integer saldoAtual;

    @Column(name = "saldo_calculado")
    public Integer saldoCalculado;

    @Column(name = "dif_saldo")
    public Integer difSaldo;

    @Column(name = "tot_transacao_c")
    public Integer totTransacaoC;

    @Column(name = "tot_transacao_d")
    public Integer totTransacaoD;
}

