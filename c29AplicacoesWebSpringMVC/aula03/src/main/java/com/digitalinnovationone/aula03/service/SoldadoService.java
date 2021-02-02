package com.digitalinnovationone.aula03.service;

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
}
