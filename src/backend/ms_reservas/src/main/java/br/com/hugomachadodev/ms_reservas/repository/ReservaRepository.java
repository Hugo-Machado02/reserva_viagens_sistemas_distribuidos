package br.com.hugomachadodev.ms_reservas.repository;

import br.com.hugomachadodev.ms_reservas.enums.StatusReserva;
import br.com.hugomachadodev.ms_reservas.model.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    List<Reserva> findByUsuarioId(Long usuarioId);
    
    List<Reserva> findByStatus(StatusReserva status);
    
    List<Reserva> findByUsuarioIdAndStatus(Long usuarioId, StatusReserva status);
}
