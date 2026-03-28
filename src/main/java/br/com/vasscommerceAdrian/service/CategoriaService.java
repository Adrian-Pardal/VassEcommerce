package br.com.vasscommerceAdrian.service;
import br.com.vasscommerceAdrian.dto.CategoriaDto;
import br.com.vasscommerceAdrian.dto.ProdutoDto;
import br.com.vasscommerceAdrian.entity.CategoriaEntity;
import br.com.vasscommerceAdrian.entity.CidadeEntity;
import br.com.vasscommerceAdrian.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void inserir(CategoriaDto categoria){
        CategoriaEntity categoriaEntity = new CategoriaEntity(categoria);
        categoriaRepository.save(categoriaEntity);
    }

    public List<CategoriaDto> buscarTodos(){
        return categoriaRepository.findAll().stream()
                .map(CategoriaDto::new)
                .collect(Collectors.toList());
    }

    public CategoriaDto buscarPorNome(String nome) {
        return new CategoriaDto(categoriaRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada")));
    }

    public CategoriaDto buscarPorId(Long id){
        return new CategoriaDto(categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada")));
    }
    public List<ProdutoDto> buscarComFiltros(String nome, BigDecimal min, BigDecimal max) {
        return categoriaRepository.buscarComFiltros(nome, min, max).stream()
                .map(ProdutoDto::new)
                .collect(Collectors.toList());
    }


    public void deletar(Long id){
        categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        categoriaRepository.deleteById(id);
    }

    public CategoriaDto atualizar(Long id,CategoriaDto categoriaDto){
        Optional<CategoriaEntity> categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isPresent()) {
            CategoriaEntity categoria = categoriaOptional.get();
            categoria.setNome(categoriaDto.getNome());
            categoria.setDescricao(categoriaDto.getDescricao());
            categoria.setImagemSimboloUM(categoriaDto.getImagemSimboloUM());
            return new CategoriaDto(categoriaRepository.save(categoria));
        }else{
            throw new RuntimeException("Categoria não encontrada");
        }
    }
}
