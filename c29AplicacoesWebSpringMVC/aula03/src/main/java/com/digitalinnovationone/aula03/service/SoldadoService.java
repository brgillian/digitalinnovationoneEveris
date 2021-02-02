package com.digitalinnovationone.aula03.service;

import java.util.Arrays;
import java.util.List;

import com.digitalinnovationone.aula03.controller.request.SoldadoEditRequest;
import com.digitalinnovationone.aula03.dto.Soldado;

public class SoldadoService {
    public Soldado buscarSoldado(String cpf){
        Soldado soldado = new Soldado();
        soldado.setCpf(cpf);
        soldado.setNome("Legolas");
        soldado.setRaca("Elfo");
        soldado.setArma("Arco e flexa");
        return soldado;
    }
    public void criarSoldado(Soldado soldado){}

    public void alterarSoldado(String cpf, SoldadoEditRequest soldadoEditRequest){}

    public void deletarSoldado(String cpf){}

    public List<Soldado>buscarSoldado(){
        Soldado soldado1 = new Soldado();
        soldado.setCpf("123456789");
        soldado.setNome("Legolas");
        soldado.setRaca("Elfo");
        soldado.setArma("Arco e flexa");

        Soldado soldado2 = new Soldado();
        soldado.setCpf("987654321");
        soldado.setNome("Arthur");
        soldado.setRaca("Elfa");
        soldado.setArma("Arco e flexa");

        return Arrays.asList(soldado1, soldado2);
    }
}
