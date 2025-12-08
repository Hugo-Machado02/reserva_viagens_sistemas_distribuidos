package com.joseliojr.ms.voos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseliojr.ms.voos.model.Voo;

import java.util.List;
import java.util.Optional;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long> {
    
    Optional<Voo> findByNumeroVoo(String numeroVoo);
    
    List<Voo> findByOrigemAndDestino(String origem, String destino);
}
