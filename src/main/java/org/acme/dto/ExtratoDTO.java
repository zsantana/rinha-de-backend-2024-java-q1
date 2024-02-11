package org.acme.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record ExtratoDTO (

    SaldoDTO saldo,
    
    @JsonProperty("ultimas_transacoes")
    List<TransacaoResponseDTO> ultimasTransacoes
){}
    
