package br.com.hugomachadodev.ms_hoteis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class QuartoDTO {

    private Long id;

    @NotBlank(message = "Tipo do quarto é obrigatório")
    private String tipo;

    @NotNull(message = "Número do quarto é obrigatório")
    private Integer numero;

    @NotNull(message = "Capacidade é obrigatória")
    private Integer capacidade;

    @NotNull(message = "Valor da reserva é obrigatório")
    @Positive(message = "Valor deve ser positivo")
    private BigDecimal valorReserva;

    private Boolean disponivel;

    private Long hotelId;
    private String hotelNome;
    private String hotelCidade;

    public QuartoDTO() {
    }

    public QuartoDTO(Long id, String tipo, Integer numero, Integer capacidade, BigDecimal valorReserva, 
                    Boolean disponivel, Long hotelId, String hotelNome, String hotelCidade) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
        this.capacidade = capacidade;
        this.valorReserva = valorReserva;
        this.disponivel = disponivel;
        this.hotelId = hotelId;
        this.hotelNome = hotelNome;
        this.hotelCidade = hotelCidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public BigDecimal getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(BigDecimal valorReserva) {
        this.valorReserva = valorReserva;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelNome() {
        return hotelNome;
    }

    public void setHotelNome(String hotelNome) {
        this.hotelNome = hotelNome;
    }

    public String getHotelCidade() {
        return hotelCidade;
    }

    public void setHotelCidade(String hotelCidade) {
        this.hotelCidade = hotelCidade;
    }
}
