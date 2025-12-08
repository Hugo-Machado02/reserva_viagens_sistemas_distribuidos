package br.com.hugomachadodev.ms_reservas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public class ReservaRequest {

    @NotNull(message = "ID do usuário é obrigatório")
    private Long usuarioId;

    @NotNull(message = "ID do voo é obrigatório")
    private Long vooId;

    @NotNull(message = "ID do hotel é obrigatório")
    private Long hotelId;

    @NotBlank(message = "Data de check-in é obrigatória")
    private String dataCheckIn;

    @NotBlank(message = "Data de check-out é obrigatória")
    private String dataCheckOut;

    public ReservaRequest() {
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
}
