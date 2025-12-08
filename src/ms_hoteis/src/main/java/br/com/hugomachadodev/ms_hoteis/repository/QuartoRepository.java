package br.com.hugomachadodev.ms_hoteis.repository;

import br.com.hugomachadodev.ms_hoteis.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    List<Quarto> findByHotelId(Long hotelId);
    List<Quarto> findByDisponivel(Boolean disponivel);
}
