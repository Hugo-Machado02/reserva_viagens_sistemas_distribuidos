package com.joseliojr.ms_voos.service;

import com.joseliojr.ms_voos.dto.*;
import com.joseliojr.ms_voos.exception.BusinessException;
import com.joseliojr.ms_voos.exception.ResourceNotFoundException;
import com.joseliojr.ms_voos.model.Assento;
import com.joseliojr.ms_voos.model.Voo;
import com.joseliojr.ms_voos.repository.AssentoRepository;
import com.joseliojr.ms_voos.repository.VooRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VooService {

    private final VooRepository vooRepository;
    private final AssentoRepository assentoRepository;

    public VooService(VooRepository vooRepository, AssentoRepository assentoRepository) {
        this.vooRepository = vooRepository;
        this.assentoRepository = assentoRepository;
    }

    @Transactional
    public VooResponseDTO criarVoo(VooRequestDTO request) {
        if (vooRepository.findByNumeroVoo(request.getNumeroVoo()).isPresent()) {
            throw new BusinessException("Já existe um voo com o número: " + request.getNumeroVoo());
        }

        Voo voo = new Voo(
            request.getNumeroVoo(),
            request.getOrigem(),
            request.getDestino(),
            request.getDataHoraPartida(),
            request.getDataHoraChegada(),
            request.getCompanhiaAerea(),
            request.getCapacidadeTotal()
        );

        voo = vooRepository.save(voo);

        for (int i = 1; i <= request.getCapacidadeTotal(); i++) {
            String numeroAssento = String.format("%03d", i);
            Assento assento = new Assento(numeroAssento, voo);
            voo.getAssentos().add(assento);
        }

        voo = vooRepository.save(voo);
        return toResponseDTO(voo);
    }

    public List<VooResponseDTO> buscarTodosVoos() {
        return vooRepository.findAll().stream()
            .map(this::toResponseDTO)
            .collect(Collectors.toList());
    }

    public VooResponseDTO buscarVooPorId(Long id) {
        Voo voo = vooRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Voo não encontrado com id: " + id));
        return toResponseDTO(voo);
    }

    public List<VooResponseDTO> buscarVoosPorRota(String origem, String destino, String data) {
        List<Voo> voos = vooRepository.findByOrigemAndDestino(origem, destino);
        return voos.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional
    public AssentoResponseDTO reservarAssento(Long vooId, ReservaRequestDTO request) {
        Voo voo = vooRepository.findById(vooId)
            .orElseThrow(() -> new ResourceNotFoundException("Voo não encontrado com id: " + vooId));

        Assento assento = assentoRepository.findByVooIdAndNumeroAssento(vooId, request.getNumeroAssento())
            .orElseThrow(() -> new ResourceNotFoundException(
                "Assento " + request.getNumeroAssento() + " não encontrado no voo"));

        if (!assento.getDisponivel()) {
            throw new BusinessException("Assento " + request.getNumeroAssento() + " já está reservado");
        }

        assento.setDisponivel(false);
        assento.setNomePassageiro(request.getNomePassageiro());
        assento = assentoRepository.save(assento);

        return toAssentoResponseDTO(assento);
    }

    @Transactional
    public void cancelarReserva(Long vooId, Long assentoId) {
        Assento assento = assentoRepository.findById(assentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Assento não encontrado com id: " + assentoId));

        if (!assento.getVoo().getId().equals(vooId)) {
            throw new BusinessException("Assento não pertence ao voo informado");
        }

        if (assento.getDisponivel()) {
            throw new BusinessException("Assento não está reservado");
        }

        assento.setDisponivel(true);
        assento.setNomePassageiro(null);
        assentoRepository.save(assento);
    }

    public List<AssentoResponseDTO> listarAssentosDoVoo(Long vooId) {
        if (!vooRepository.existsById(vooId)) {
            throw new ResourceNotFoundException("Voo não encontrado com id: " + vooId);
        }
        return assentoRepository.findByVooId(vooId).stream()
            .map(this::toAssentoResponseDTO)
            .collect(Collectors.toList());
    }

    private VooResponseDTO toResponseDTO(Voo voo) {
        Long assentosDisponiveis = assentoRepository.countByVooIdAndDisponivelTrue(voo.getId());
        return new VooResponseDTO(
            voo.getId(),
            voo.getNumeroVoo(),
            voo.getOrigem(),
            voo.getDestino(),
            voo.getDataHoraPartida(),
            voo.getDataHoraChegada(),
            voo.getCompanhiaAerea(),
            voo.getCapacidadeTotal(),
            assentosDisponiveis.intValue()
        );
    }

    private AssentoResponseDTO toAssentoResponseDTO(Assento assento) {
        return new AssentoResponseDTO(
            assento.getId(),
            assento.getNumeroAssento(),
            assento.getDisponivel(),
            assento.getNomePassageiro()
        );
    }
}
