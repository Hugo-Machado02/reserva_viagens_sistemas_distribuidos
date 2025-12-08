package br.com.hugomachadodev.ms_hoteis.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hoteis")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O campo Endereço é obrigatório")
    @Column(nullable = false)
    private String endereco;

    @NotBlank(message = "O campo Cidade é obrigatória")
    @Column(nullable = false)
    private String cidade;

    @NotNull(message = "O campo Estrelas é obrigatório")
    @Column(nullable = false)
    private Integer estrelas;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quarto> quartos = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(String nome, String endereco, String cidade, Integer estrelas) {
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

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }
}
