package com.digitalinnovationone.aula03.resource;

import com.digitalinnovationone.aula03.controller.SoldadoController;
import com.digitalinnovationone.aula03.controller.response.SoldadoListResponse;
import com.digitalinnovationone.aula03.entity.SoldadoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.hateoas.Links;
import org.springframework.stereotype.Component;


@Component
public class ResourceSoldado {
    private ObjectMapper objectMapper;

    public ResourceSoldado(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public SoldadoListResponse criarLink(SoldadoEntity soldadoEntity){
        SoldadoListResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoListResponse.class);
        Link link = linkTo(methodOn(SoldadoController.class).buscarSoldado(soldadoEntity.getId())).whithSelfRel();
        soldadoListResponse.add(link);
        return soldadoListResponse;
    }

    public SoldadoListResponse criarLinkDetalhe(SoldadoEntity soldadoEntity){
        SoldadoListResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoListResponse.class);
        soldadoEntity.getStatus();
        Link link = linkTo(methodOn(SoldadoController.class).deletarSoldado(soldadoEntity.getId())).whithSelfRel();
        soldadoListResponse.add(link);
        return soldadoListResponse;
    }

    
}
