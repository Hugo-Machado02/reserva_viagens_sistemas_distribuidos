package com.joseliojr.ms_voos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assentos")
public class Assento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String numeroAssento;
    
    @Column(nullable = false)
    private Boolean disponivel = true;
    
    @Column
    private String nomePassageiro;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voo_id", nullable = false)
    private Voo voo;
    
    public Assento() {}
    
    public Assento(String numeroAssento, Voo voo) {
        this.numeroAssento = numeroAssento;
        this.voo = voo;
        this.disponivel = true;
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

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }
}
