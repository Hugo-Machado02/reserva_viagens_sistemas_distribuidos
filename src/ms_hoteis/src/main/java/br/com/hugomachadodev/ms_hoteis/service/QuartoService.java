package br.com.hugomachadodev.ms_hoteis.service;

import br.com.hugomachadodev.ms_hoteis.exception.ResourceNotFoundException;
import br.com.hugomachadodev.ms_hoteis.model.Hotel;
import br.com.hugomachadodev.ms_hoteis.model.Quarto;
import br.com.hugomachadodev.ms_hoteis.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelService hotelService;

    public List<Quarto> listarTodos() {
        return quartoRepository.findAll();
    }

    public Quarto buscarPorId(Long id) {
        return quartoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado com id: " + id));
    }

    public List<Quarto> buscarPorHotel(Long hotelId) {
        hotelService.buscarPorId(hotelId);
        return quartoRepository.findByHotelId(hotelId);
    }

    public List<Quarto> buscarDisponiveis() {
        return quartoRepository.findByDisponivel(true);
    }

    @Transactional
    public Quarto criar(Long hotelId, Quarto quarto) {
        Hotel hotel = hotelService.buscarPorId(hotelId);
        quarto.setHotel(hotel);
        return quartoRepository.save(quarto);
    }

    @Transactional
    public Quarto atualizar(Long id, Quarto quartoAtualizado) {
        Quarto quarto = buscarPorId(id);
        quarto.setTipo(quartoAtualizado.getTipo());
        quarto.setCapacidade(quartoAtualizado.getCapacidade());
        quarto.setValorReserva(quartoAtualizado.getValorReserva());
        quarto.setDisponivel(quartoAtualizado.getDisponivel());
        return quartoRepository.save(quarto);
    }

    @Transactional
    public void deletar(Long id) {
        Quarto quarto = buscarPorId(id);
        quartoRepository.delete(quarto);
    }
}
