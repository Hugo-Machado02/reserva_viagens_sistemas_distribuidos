package br.com.hugomachadodev.ms_hoteis.service;

import br.com.hugomachadodev.ms_hoteis.dto.HotelDTO;
import br.com.hugomachadodev.ms_hoteis.exception.ResourceNotFoundException;
import br.com.hugomachadodev.ms_hoteis.model.Hotel;
import br.com.hugomachadodev.ms_hoteis.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository repository;

    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public List<HotelDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public HotelDTO buscarPorId(Long id) {
        return toDTO(buscarEntity(id));
    }

    public List<HotelDTO> buscarPorCidade(String cidade) {
        return repository.findByCidade(cidade).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public HotelDTO criar(HotelDTO dto) {
        Hotel hotel = toEntity(dto);
        return toDTO(repository.save(hotel));
    }

    @Transactional
    public HotelDTO atualizar(Long id, HotelDTO dto) {
        Hotel hotel = buscarEntity(id);
        hotel.setNome(dto.getNome());
        hotel.setEndereco(dto.getEndereco());
        hotel.setCidade(dto.getCidade());
        hotel.setEstrelas(dto.getEstrelas());
        return toDTO(repository.save(hotel));
    }

    @Transactional
    public void deletar(Long id) {
        repository.delete(buscarEntity(id));
    }

    public Hotel buscarEntity(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Hotel não encontrado com id: " + id));
    }

    private HotelDTO toDTO(Hotel h) {
        return new HotelDTO(h.getId(), h.getNome(), h.getEndereco(), h.getCidade(), h.getEstrelas());
    }

    private Hotel toEntity(HotelDTO dto) {
        Hotel h = new Hotel();
        h.setNome(dto.getNome());
        h.setEndereco(dto.getEndereco());
        h.setCidade(dto.getCidade());
        h.setEstrelas(dto.getEstrelas());
        return h;
    }
}
