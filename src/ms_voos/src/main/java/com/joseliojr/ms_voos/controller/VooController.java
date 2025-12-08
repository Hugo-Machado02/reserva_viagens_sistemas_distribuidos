package com.joseliojr.ms.voos.controller;

import com.joseliojr.ms.voos.dto.*;
import com.joseliojr.ms.voos.service.VooService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voos")
public class VooController {

    private final VooService vooService;

    public VooController(VooService vooService) {
        this.vooService = vooService;
    }

    @PostMapping
    public ResponseEntity<VooResponseDTO> criarVoo(@RequestBody VooRequestDTO request) {
        VooResponseDTO response = vooService.criarVoo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<VooResponseDTO>> listarVoos() {
        List<VooResponseDTO> voos = vooService.buscarTodosVoos();
        return ResponseEntity.ok(voos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VooResponseDTO> buscarVooPorId(@PathVariable Long id) {
        VooResponseDTO voo = vooService.buscarVooPorId(id);
        return ResponseEntity.ok(voo);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<VooResponseDTO>> buscarVoosPorRota(
            @RequestParam String origem,
            @RequestParam String destino,
            @RequestParam(required = false) String data) {
        List<VooResponseDTO> voos = vooService.buscarVoosPorRota(origem, destino, data);
        return ResponseEntity.ok(voos);
    }

    @GetMapping("/{vooId}/assentos")
    public ResponseEntity<List<AssentoResponseDTO>> listarAssentos(@PathVariable Long vooId) {
        List<AssentoResponseDTO> assentos = vooService.listarAssentosDoVoo(vooId);
        return ResponseEntity.ok(assentos);
    }

    @PostMapping("/{vooId}/reservas")
    public ResponseEntity<AssentoResponseDTO> reservarAssento(
            @PathVariable Long vooId,
            @RequestBody ReservaRequestDTO request) {
        AssentoResponseDTO assento = vooService.reservarAssento(vooId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(assento);
    }

    @DeleteMapping("/{vooId}/reservas/{assentoId}")
    public ResponseEntity<Void> cancelarReserva(
            @PathVariable Long vooId,
            @PathVariable Long assentoId) {
        vooService.cancelarReserva(vooId, assentoId);
        return ResponseEntity.noContent().build();
    }
}
