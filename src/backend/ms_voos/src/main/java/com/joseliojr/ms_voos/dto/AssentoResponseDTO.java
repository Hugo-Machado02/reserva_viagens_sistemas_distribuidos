package com.joseliojr.ms_voos.dto;

public class AssentoResponseDTO {
    
    private Long id;
    private String numeroAssento;
    private Boolean disponivel;
    private String nomePassageiro;

    public AssentoResponseDTO() {}

    public AssentoResponseDTO(Long id, String numeroAssento, Boolean disponivel, 
                             String nomePassageiro) {
        this.id = id;
        this.numeroAssento = numeroAssento;
        this.disponivel = disponivel;
        this.nomePassageiro = nomePassageiro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(String numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }
}
