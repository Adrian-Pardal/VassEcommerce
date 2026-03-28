package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.EstadoDto;
import br.com.vasscommerceAdrian.entity.EstadoEntity;
import br.com.vasscommerceAdrian.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public EstadoEntity inserir(EstadoDto estadoDto) {
        EstadoEntity estado = new EstadoEntity();
        estado.setNome(estadoDto.getNome());
        estado.setSigla(estadoDto.getSigla());
        return estadoRepository.save(estado);
    }

    public Optional<EstadoEntity> buscarPorId(Long id) {
        return estadoRepository.findById(id);
    }

    public List<EstadoEntity> buscarTodos() {
        return estadoRepository.findAll();
    }

    public EstadoEntity atualizar(Long id, EstadoDto estadoDto) {
        Optional<EstadoEntity> estadoOptional = estadoRepository.findById(id);
        if (estadoOptional.isPresent()) {
            EstadoEntity estado = estadoOptional.get();
            estado.setNome(estadoDto.getNome());
            estado.setSigla(estadoDto.getSigla());
            return estadoRepository.save(estado);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if (estadoRepository.existsById(id)) {
            estadoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
