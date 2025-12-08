package br.com.hugomachadodev.ms_hoteis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HotelDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "Cidade é obrigatória")
    private String cidade;

    @NotNull(message = "Estrelas é obrigatório")
    private Integer estrelas;

    public HotelDTO() {
    }

    public HotelDTO(Long id, String nome, String endereco, String cidade, Integer estrelas) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estrelas = estrelas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(Integer estrelas) {
        this.estrelas = estrelas;
    }
}
