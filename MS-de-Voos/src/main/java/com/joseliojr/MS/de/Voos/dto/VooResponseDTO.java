package com.joseliojr.MS.de.Voos.dto;

public class VooResponseDTO {
    
    private Long id;
    private String numeroVoo;
    private String origem;
    private String destino;
    private String dataHoraPartida;
    private String dataHoraChegada;
    private String companhiaAerea;
    private Integer capacidadeTotal;
    private Integer assentosDisponiveis;

    public VooResponseDTO() {}

    public VooResponseDTO(Long id, String numeroVoo, String origem, String destino, 
                         String dataHoraPartida, String dataHoraChegada, 
                         String companhiaAerea, Integer capacidadeTotal, 
                         Integer assentosDisponiveis) {
        this.id = id;
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.dataHoraPartida = dataHoraPartida;
        this.dataHoraChegada = dataHoraChegada;
        this.companhiaAerea = companhiaAerea;
        this.capacidadeTotal = capacidadeTotal;
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(String dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public String getDataHoraChegada() {
        return dataHoraChegada;
    }

    public void setDataHoraChegada(String dataHoraChegada) {
        this.dataHoraChegada = dataHoraChegada;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Integer capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public Integer getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(Integer assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }
}
