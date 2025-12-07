package br.com.hugomachadodev.ms_hoteis.service;

import br.com.hugomachadodev.ms_hoteis.exception.ResourceNotFoundException;
import br.com.hugomachadodev.ms_hoteis.model.Hotel;
import br.com.hugomachadodev.ms_hoteis.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> listarTodos() {
        return hotelRepository.findAll();
    }

    public Hotel buscarPorId(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel não encontrado com id: " + id));
    }

    public List<Hotel> buscarPorCidade(String cidade) {
        return hotelRepository.findByCidade(cidade);
    }

    @Transactional
    public Hotel criar(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Transactional
    public Hotel atualizar(Long id, Hotel hotelAtualizado) {
        Hotel hotel = buscarPorId(id);
        hotel.setNome(hotelAtualizado.getNome());
        hotel.setEndereco(hotelAtualizado.getEndereco());
        hotel.setCidade(hotelAtualizado.getCidade());
        hotel.setEstrelas(hotelAtualizado.getEstrelas());
        return hotelRepository.save(hotel);
    }

    @Transactional
    public void deletar(Long id) {
        Hotel hotel = buscarPorId(id);
        hotelRepository.delete(hotel);
    }
}
