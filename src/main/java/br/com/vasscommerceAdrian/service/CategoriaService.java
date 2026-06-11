package br.com.vasscommerceAdrian.service;
import br.com.vasscommerceAdrian.ServiceInterface.CategoriaServiceInterface;
import br.com.vasscommerceAdrian.dto.CategoriaRequestDto;
import br.com.vasscommerceAdrian.dto.CategoriaResponseDto;
import br.com.vasscommerceAdrian.dto.ProdutoRequestDto;
import br.com.vasscommerceAdrian.entity.CategoriaEntity;
import br.com.vasscommerceAdrian.mapper.CategoriaMapper;
import br.com.vasscommerceAdrian.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements CategoriaServiceInterface {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaResponseDto inserir(CategoriaRequestDto categoria){
        CategoriaEntity categoriaEntity = new CategoriaEntity(categoria);
        return CategoriaMapper.toResponseDto(categoriaRepository.save(CategoriaMapper.toEntity(categoria)));
    }

    public List<CategoriaResponseDto> buscarTodos(){
        return categoriaRepository.findAll().stream()
                .map(CategoriaMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public CategoriaResponseDto buscarPorNome(String nome) {
        return categoriaRepository.findByNome(nome)
                .map(CategoriaMapper :: toResponseDto)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public CategoriaResponseDto buscarPorId(Long id){
        return categoriaRepository.findById(id).map(CategoriaMapper :: toResponseDto)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }


    public void deletar(Long id){
        categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        categoriaRepository.deleteById(id);
    }

    public CategoriaResponseDto atualizar(Long id, CategoriaRequestDto categoriaDto){
        Optional<CategoriaEntity> categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isPresent()) {
            CategoriaEntity categoria = categoriaOptional.get();

            CategoriaMapper.updateEntity(categoria , categoriaDto);

            return CategoriaMapper.toResponseDto(categoriaRepository.save(categoria));
        }else{
            throw new RuntimeException("Categoria não encontrada");
        }
    }
}
