package br.com.hugomachadodev.ms_hoteis.controller;

import br.com.hugomachadodev.ms_hoteis.model.Hotel;
import br.com.hugomachadodev.ms_hoteis.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hoteis")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> listarTodos() {
        return ResponseEntity.ok(hotelService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.buscarPorId(id));
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Hotel>> buscarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(hotelService.buscarPorCidade(cidade));
    }

    @PostMapping
    public ResponseEntity<Hotel> criar(@Valid @RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.criar(hotel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> atualizar(@PathVariable Long id, @Valid @RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.atualizar(id, hotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        hotelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
