package org.acme.mapper;

import org.acme.dto.TransacaoRequestDTO;
import org.acme.entity.Transacao;
// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

// @Mapper(componentModel = "cdi")
public interface TransacaoMapper {

    // @Mapping(target = "realizada_em", expression = "java(LocalDateTime.now())")
    Transacao toEntity(Integer id, TransacaoRequestDTO dto);

}
