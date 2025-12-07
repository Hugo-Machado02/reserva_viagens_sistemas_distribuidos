package com.joseliojr.MS.de.Voos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseliojr.MS.de.Voos.model.Assento;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssentoRepository extends JpaRepository<Assento, Long> {
    
    List<Assento> findByVooId(Long vooId);
    
    Optional<Assento> findByVooIdAndNumeroAssento(Long vooId, String numeroAssento);
    
    Long countByVooIdAndDisponivelTrue(Long vooId);
}
