package com.joseliojr.MS.de.Voos.dto;

public class ReservaRequestDTO {
    
    private String numeroAssento;
    private String nomePassageiro;

    public String getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(String numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }
}
