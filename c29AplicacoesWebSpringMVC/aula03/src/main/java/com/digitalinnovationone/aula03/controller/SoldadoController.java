package com.digitalinnovationone.aula03.controller;

import java.util.List;

import com.digitalinnovationone.aula03.controller.request.SoldadoEditRequest;
import com.digitalinnovationone.aula03.dto.Soldado;
import com.digitalinnovationone.aula03.service.SoldadoService;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {
    
    private SoldadoService soldadoService;

    public SoldadoController(SoldadoService soldadoService){
        this.soldadoService = soldadoService;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable() String cpf){
       Soldado soldado = soldadoService.buscarSoldado(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(soldado);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado){
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity editarSoldado(@PathVariable() String cpf,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest){
        
        soldadoService.alterarSoldado(cpf, soldadoEditRequest);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarSoldado(@PathVariable String cpf){
        soldadoService.deletarSoldado(cpf);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Soldado>> buscarSoldado(){
        List<Soldado> soldados = soldadoService.buscarSoldado();
        return ResponseEntity.status(HttpStatus.OK).body(soldados);
    }
}
