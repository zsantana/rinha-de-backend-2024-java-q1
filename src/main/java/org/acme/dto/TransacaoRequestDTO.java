package org.acme.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record TransacaoRequestDTO(

    // @NotNull @Positive 
    String valor,

    @JsonIgnore 
    Long cliente_id,

    // @NotBlank
    // @Size(min = 1, max = 1)
    String tipo,
    
    // @NotBlank @Size(min = 1, max = 10) 
    String descricao
) {

    public boolean ehValida() {
        return valor != null
                && tipo != null
                && descricao != null
                && valorEhInteger()
                && Integer.parseInt(valor) > 0
                && tipo.length() == 1
                && (tipo.charAt(0)  == 'c' || tipo.charAt(0) == 'd')
                && descricao.length() > 0
                && descricao.length() <= 10;
    }

    private boolean valorEhInteger() {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    
}



