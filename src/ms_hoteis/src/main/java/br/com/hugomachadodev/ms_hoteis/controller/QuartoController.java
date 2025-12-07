package br.com.hugomachadodev.ms_hoteis.controller;

import br.com.hugomachadodev.ms_hoteis.model.Quarto;
import br.com.hugomachadodev.ms_hoteis.service.QuartoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quartos")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public ResponseEntity<List<Quarto>> listarTodos() {
        return ResponseEntity.ok(quartoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(quartoService.buscarPorId(id));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Quarto>> buscarPorHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(quartoService.buscarPorHotel(hotelId));
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Quarto>> buscarDisponiveis() {
        return ResponseEntity.ok(quartoService.buscarDisponiveis());
    }

    @PostMapping("/hotel/{hotelId}")
    public ResponseEntity<Quarto> criar(@PathVariable Long hotelId, @Valid @RequestBody Quarto quarto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quartoService.criar(hotelId, quarto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quarto> atualizar(@PathVariable Long id, @Valid @RequestBody Quarto quarto) {
        return ResponseEntity.ok(quartoService.atualizar(id, quarto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        quartoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
