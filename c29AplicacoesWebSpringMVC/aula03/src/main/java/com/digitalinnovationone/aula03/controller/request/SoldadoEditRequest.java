package com.digitalinnovationone.aula03.controller.request;

public class SoldadoEditRequest {
    private String nome;
    private String raca;
    private String arma;

    public String getNome() {
        return nome;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
