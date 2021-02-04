package com.digitalinnovationone.aula03.service;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalinnovationone.aula03.controller.request.SoldadoEditRequest;
import com.digitalinnovationone.aula03.controller.response.SoldadoListResponse;
import com.digitalinnovationone.aula03.controller.response.SoldadoResponse;
import com.digitalinnovationone.aula03.dto.Soldado;
import com.digitalinnovationone.aula03.entity.SoldadoEntity;
import com.digitalinnovationone.aula03.repostory.SoldadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

//import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;


@Service
public class SoldadoService {

    private SoldadoRepository soldadoRepository;
    private ObjectMapper objectMapper;

    public SoldadoService(SoldadoRepository soldadoRepository, ObjectMapper objectMapper) {
        this.soldadoRepository = soldadoRepository;
        this.objectMapper = objectMapper;
    }

    public SoldadoResponse buscarSoldado(Long id) {
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow();
        SoldadoResponse soldadoResponse = objectMapper.convertValue(soldado, SoldadoResponse.class);
        return soldadoResponse;
    }

    public void criarSoldado(Soldado soldado){
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldado, SoldadoEntity.class);
        soldadoRepository.save(soldadoEntity);
    }

    public void alterarSoldado(Long id, SoldadoEditRequest soldadoEditRequest) {
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldadoEditRequest, SoldadoEntity.class);
        soldadoEntity.setId(id);
        soldadoRepository.save(soldadoEntity);
    }

    public void deletarSoldado(Long id) {
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow();
        soldadoRepository.delete(soldado);
    }

    public List<SoldadoListResponse> buscarSoldados(){
        List<SoldadoEntity> all = soldadoRepository.findAll();
        List<SoldadoListResponse> soldadoStream = all.stream()
                .map(it -> resourceSoldado.criarLink(it))
                .collect(Collectors.toList());
        return new Resources<>(soldadoStream);
    }
}