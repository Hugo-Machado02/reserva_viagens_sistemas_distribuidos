package com.joseliojr.MS.de.Reservas.repository;

import com.joseliojr.MS.de.Reservas.enums.StatusReserva;
import com.joseliojr.MS.de.Reservas.model.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    List<Reserva> findByUsuarioId(Long usuarioId);
    
    List<Reserva> findByStatus(StatusReserva status);
    
    List<Reserva> findByUsuarioIdAndStatus(Long usuarioId, StatusReserva status);
}
