package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.CidadeDto;
import br.com.vasscommerceAdrian.entity.CidadeEntity;
import br.com.vasscommerceAdrian.entity.EstadoEntity;
import br.com.vasscommerceAdrian.repository.CidadeRepository;
import br.com.vasscommerceAdrian.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public CidadeEntity inserir(CidadeDto cidadeDto) {
        CidadeEntity cidade = new CidadeEntity();
        cidade.setNome(cidadeDto.getNome());
        
        if (cidadeDto.getEstadoId() != null) {
            Optional<EstadoEntity> estado = estadoRepository.findById(cidadeDto.getEstadoId());
            estado.ifPresent(cidade::setEstado);
        }
        
        return cidadeRepository.save(cidade);
    }

    public Optional<CidadeEntity> buscarPorId(Long id) {
        return cidadeRepository.findById(id);
    }

    public List<CidadeEntity> buscarTodos() {
        return cidadeRepository.findAll();
    }

    public CidadeEntity atualizar(Long id, CidadeDto cidadeDto) {
        Optional<CidadeEntity> cidadeOptional = cidadeRepository.findById(id);
        if (cidadeOptional.isPresent()) {
            CidadeEntity cidade = cidadeOptional.get();
            cidade.setNome(cidadeDto.getNome());
            
            if (cidadeDto.getEstadoId() != null) {
                Optional<EstadoEntity> estado = estadoRepository.findById(cidadeDto.getEstadoId());
                cidade.setEstado(estado.get());
            }
            
            return cidadeRepository.save(cidade);
        }
        return null;
    }

    public List<CidadeEntity> buscarPorEstado(Long estadoId) {
        return cidadeRepository.findByEstadoId(estadoId);
    }

    public boolean deletar(Long id) {
        if (cidadeRepository.existsById(id)) {
            cidadeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
