package br.com.hugomachadodev.ms_hoteis.repository;

import br.com.hugomachadodev.ms_hoteis.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCidade(String cidade);
}
