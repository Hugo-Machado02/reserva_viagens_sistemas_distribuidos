package br.com.hugomachadodev.ms_reservas.dto;

import br.com.hugomachadodev.ms_reservas.enums.StatusReserva;
import br.com.hugomachadodev.ms_reservas.model.Reserva;

import java.time.LocalDateTime;

public class ReservaResponse {

    private Long id;
    private Long usuarioId;
    private Long vooId;
    private Long hotelId;
    private String dataCheckIn;
    private String dataCheckOut;
    private StatusReserva status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public ReservaResponse() {
    }

    public ReservaResponse(Reserva reserva) {
        this.id = reserva.getId();
        this.usuarioId = reserva.getUsuarioId();
        this.vooId = reserva.getVooId();
        this.hotelId = reserva.getHotelId();
        this.dataCheckIn = reserva.getDataCheckIn();
        this.dataCheckOut = reserva.getDataCheckOut();
        this.status = reserva.getStatus();
        this.dataCriacao = reserva.getDataCriacao();
        this.dataAtualizacao = reserva.getDataAtualizacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getVooId() {
        return vooId;
    }

    public void setVooId(Long vooId) {
        this.vooId = vooId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(String dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(String dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
