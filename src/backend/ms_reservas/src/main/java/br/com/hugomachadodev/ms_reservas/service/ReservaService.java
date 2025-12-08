package br.com.hugomachadodev.ms_reservas.service;

import br.com.hugomachadodev.ms_reservas.dto.ReservaRequest;
import br.com.hugomachadodev.ms_reservas.dto.ReservaResponse;
import br.com.hugomachadodev.ms_reservas.enums.StatusReserva;
import br.com.hugomachadodev.ms_reservas.exception.BusinessException;
import br.com.hugomachadodev.ms_reservas.exception.ResourceNotFoundException;
import br.com.hugomachadodev.ms_reservas.exception.ServiceCommunicationException;
import br.com.hugomachadodev.ms_reservas.model.Reserva;
import br.com.hugomachadodev.ms_reservas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final WebClient.Builder webClientBuilder;

    @Value("${ms.voos.url}")
    private String voosServiceUrl;

    @Value("${ms.hoteis.url}")
    private String hoteisServiceUrl;

    public ReservaService(ReservaRepository reservaRepository, WebClient.Builder webClientBuilder) {
        this.reservaRepository = reservaRepository;
        this.webClientBuilder = webClientBuilder;
    }

    public ReservaResponse criarReserva(ReservaRequest request) {
        verificarDisponibilidadeVoo(request.getVooId());
        verificarDisponibilidadeHotel(request.getHotelId());

        Reserva reserva = new Reserva(
                request.getUsuarioId(),
                request.getVooId(),
                request.getHotelId(),
                request.getDataCheckIn(),
                request.getDataCheckOut()
        );

        Reserva reservaSalva = reservaRepository.save(reserva);
        return new ReservaResponse(reservaSalva);
    }

    public ReservaResponse buscarReservaPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com ID: " + id));
        return new ReservaResponse(reserva);
    }

    public List<ReservaResponse> listarTodasReservas() {
        return reservaRepository.findAll().stream()
                .map(ReservaResponse::new)
                .collect(Collectors.toList());
    }

    public List<ReservaResponse> listarReservasPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId).stream()
                .map(ReservaResponse::new)
                .collect(Collectors.toList());
    }

    public ReservaResponse confirmarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com ID: " + id));

        if (reserva.getStatus() == StatusReserva.CANCELADA) {
            throw new BusinessException("Não é possível confirmar uma reserva cancelada");
        }

        reserva.setStatus(StatusReserva.CONFIRMADA);
        Reserva reservaAtualizada = reservaRepository.save(reserva);
        return new ReservaResponse(reservaAtualizada);
    }

    public ReservaResponse cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com ID: " + id));

        if (reserva.getStatus() == StatusReserva.CANCELADA) {
            throw new BusinessException("Reserva já está cancelada");
        }

        reserva.setStatus(StatusReserva.CANCELADA);
        Reserva reservaAtualizada = reservaRepository.save(reserva);
        return new ReservaResponse(reservaAtualizada);
    }

    public void deletarReserva(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reserva não encontrada com ID: " + id);
        }
        reservaRepository.deleteById(id);
    }

    private void verificarDisponibilidadeVoo(Long vooId) {
        try {
            webClientBuilder.build()
                    .get()
                    .uri(voosServiceUrl + "/api/voos/" + vooId)
                    .retrieve()
                    .bodyToMono(Object.class)
                    .block();
        } catch (Exception e) {
            throw new BusinessException("Voo não encontrado com ID: " + vooId);
        }
    }

    private void verificarDisponibilidadeHotel(Long hotelId) {
        try {
            webClientBuilder.build()
                    .get()
                    .uri(hoteisServiceUrl + "/api/hoteis/" + hotelId)
                    .retrieve()
                    .bodyToMono(Object.class)
                    .block();
        } catch (Exception e) {
            throw new BusinessException("Hotel não encontrado com ID: " + hotelId);
        }
    }
}
