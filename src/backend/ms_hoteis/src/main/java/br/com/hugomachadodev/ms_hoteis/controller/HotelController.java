package br.com.hugomachadodev.ms_hoteis.controller;

import br.com.hugomachadodev.ms_hoteis.dto.HotelDTO;
import br.com.hugomachadodev.ms_hoteis.dto.QuartoDTO;
import br.com.hugomachadodev.ms_hoteis.service.HotelService;
import br.com.hugomachadodev.ms_hoteis.service.QuartoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hoteis")
public class HotelController {

    private final HotelService hotelService;
    private final QuartoService quartoService;

    public HotelController(HotelService hotelService, QuartoService quartoService) {
        this.hotelService = hotelService;
        this.quartoService = quartoService;
    }

    // ========== ENDPOINTS DE HOTÉIS ==========

    @GetMapping
    public ResponseEntity<List<HotelDTO>> listarTodos() {
        return ResponseEntity.ok(hotelService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.buscarPorId(id));
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<HotelDTO>> buscarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(hotelService.buscarPorCidade(cidade));
    }

    @PostMapping
    public ResponseEntity<HotelDTO> criar(@Valid @RequestBody HotelDTO hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.criar(hotel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDTO> atualizar(@PathVariable Long id, @Valid @RequestBody HotelDTO hotel) {
        return ResponseEntity.ok(hotelService.atualizar(id, hotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        hotelService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // ========== ENDPOINTS DE QUARTOS ==========

    @GetMapping("/{hotelId}/quartos")
    public ResponseEntity<List<QuartoDTO>> listarQuartosPorHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(quartoService.buscarPorHotel(hotelId));
    }

    @GetMapping("/{hotelId}/quartos/disponiveis")
    public ResponseEntity<List<QuartoDTO>> listarQuartosDisponiveisPorHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(quartoService.buscarQuartosDisponiveisPorHotel(hotelId));
    }

    @GetMapping("/quartos/{quartoId}")
    public ResponseEntity<QuartoDTO> buscarQuartoPorId(@PathVariable Long quartoId) {
        return ResponseEntity.ok(quartoService.buscarPorId(quartoId));
    }

    @GetMapping("/quartos/tipo/{tipo}")
    public ResponseEntity<List<QuartoDTO>> buscarQuartosPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(quartoService.buscarPorTipo(tipo));
    }

    @GetMapping("/cidade/{cidade}/quartos/disponiveis")
    public ResponseEntity<List<QuartoDTO>> buscarQuartosDisponiveisPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(quartoService.buscarQuartosDisponiveisPorCidade(cidade));
    }

    @PostMapping("/{hotelId}/quartos")
    public ResponseEntity<QuartoDTO> adicionarQuarto(@PathVariable Long hotelId, @Valid @RequestBody QuartoDTO quarto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quartoService.criar(hotelId, quarto));
    }

    @PutMapping("/quartos/{quartoId}")
    public ResponseEntity<QuartoDTO> atualizarQuarto(@PathVariable Long quartoId, @Valid @RequestBody QuartoDTO quarto) {
        return ResponseEntity.ok(quartoService.atualizar(quartoId, quarto));
    }

    @DeleteMapping("/quartos/{quartoId}")
    public ResponseEntity<Void> deletarQuarto(@PathVariable Long quartoId) {
        quartoService.deletar(quartoId);
        return ResponseEntity.noContent().build();
    }
}
