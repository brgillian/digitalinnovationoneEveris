package com.digitalinnovationone.aula03.controller;

import java.util.List;

import com.digitalinnovationone.aula03.controller.request.SoldadoEditRequest;
import com.digitalinnovationone.aula03.controller.response.SoldadoListResponse;
import com.digitalinnovationone.aula03.controller.response.SoldadoResponse;
import com.digitalinnovationone.aula03.dto.Soldado;
import com.digitalinnovationone.aula03.service.SoldadoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jdk.internal.module.Resources;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {
    
    private SoldadoService soldadoService;
    private ObjectMapper objectMapper;

    public SoldadoController(SoldadoService soldadoService, ObjectMapper objectMapper){
        this.soldadoService = soldadoService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldadoResponse> buscarSoldado(@PathVariable() Long id){
       SoldadoResponse soldadoResponse = soldadoService.buscarSoldado(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldadoResponse);
    }

    @PostMapping
    public ResponseEntity<Soldado> criarSoldado(@RequestBody Soldado soldado){
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Soldado> editarSoldado(@PathVariable() Long id,
                                                 @RequestBody SoldadoEditRequest soldadoEditRequest){
        
        soldadoService.alterarSoldado(id, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Soldado> deletarSoldado(@PathVariable Long id){
        soldadoService.deletarSoldado(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Resources<SoldadoListResponse>> buscarSoldados(){
        Resources<SoldadoListResponse> soldadoListResponses = soldadoService.buscarSoldados();
        return ResponseEntity.status(HttpStatus.OK).body(soldadoListResponses);
    }
}
