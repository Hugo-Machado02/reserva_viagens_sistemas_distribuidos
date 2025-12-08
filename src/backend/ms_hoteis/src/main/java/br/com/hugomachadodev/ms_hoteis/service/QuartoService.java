package br.com.hugomachadodev.ms_hoteis.service;

import br.com.hugomachadodev.ms_hoteis.dto.QuartoDTO;
import br.com.hugomachadodev.ms_hoteis.exception.ResourceNotFoundException;
import br.com.hugomachadodev.ms_hoteis.model.Quarto;
import br.com.hugomachadodev.ms_hoteis.repository.QuartoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuartoService {

    private final QuartoRepository repository;
    private final HotelService hotelService;

    public QuartoService(QuartoRepository repository, HotelService hotelService) {
        this.repository = repository;
        this.hotelService = hotelService;
    }

    public List<QuartoDTO> buscarPorHotel(Long hotelId) {
        hotelService.buscarPorId(hotelId);
        return repository.findByHotelId(hotelId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<QuartoDTO> buscarQuartosDisponiveisPorHotel(Long hotelId) {
        hotelService.buscarPorId(hotelId);
        return repository.findByHotelIdAndDisponivel(hotelId, true).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public QuartoDTO buscarPorId(Long id) {
        return toDTO(buscarEntity(id));
    }

    public List<QuartoDTO> buscarPorTipo(String tipo) {
        return repository.findByTipoAndDisponivel(tipo, true).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<QuartoDTO> buscarQuartosDisponiveisPorCidade(String cidade) {
        return repository.findByHotelCidadeAndDisponivel(cidade, true).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public QuartoDTO criar(Long hotelId, QuartoDTO dto) {
        Quarto quarto = toEntity(dto);
        quarto.setHotel(hotelService.buscarEntity(hotelId));
        return toDTO(repository.save(quarto));
    }

    @Transactional
    public QuartoDTO atualizar(Long id, QuartoDTO dto) {
        Quarto quarto = buscarEntity(id);
        quarto.setTipo(dto.getTipo());
        quarto.setNumero(dto.getNumero());
        quarto.setCapacidade(dto.getCapacidade());
        quarto.setValorReserva(dto.getValorReserva());
        quarto.setDisponivel(dto.getDisponivel());
        return toDTO(repository.save(quarto));
    }

    @Transactional
    public void deletar(Long id) {
        repository.delete(buscarEntity(id));
    }

    private Quarto buscarEntity(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado com id: " + id));
    }

    private QuartoDTO toDTO(Quarto q) {
        return new QuartoDTO(q.getId(), q.getTipo(), q.getNumero(), q.getCapacidade(), 
                            q.getValorReserva(), q.getDisponivel(), 
                            q.getHotel().getId(), q.getHotel().getNome(), q.getHotel().getCidade());
    }

    private Quarto toEntity(QuartoDTO dto) {
        Quarto q = new Quarto();
        q.setTipo(dto.getTipo());
        q.setNumero(dto.getNumero());
        q.setCapacidade(dto.getCapacidade());
        q.setValorReserva(dto.getValorReserva());
        q.setDisponivel(dto.getDisponivel() != null ? dto.getDisponivel() : true);
        return q;
    }
}
