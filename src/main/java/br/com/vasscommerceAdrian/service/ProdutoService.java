package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.ProdutoRequestDto;
import br.com.vasscommerceAdrian.dto.ProdutoResponseDto;
import br.com.vasscommerceAdrian.entity.CategoriaEntity;
import br.com.vasscommerceAdrian.entity.ProdutoEntity;
import br.com.vasscommerceAdrian.mapper.ProdutoMapper;
import br.com.vasscommerceAdrian.repository.CategoriaRepository;
import br.com.vasscommerceAdrian.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ProdutoResponseDto inserir(ProdutoRequestDto produtoDto) {

        CategoriaEntity categoria = null;
        if (produtoDto.getCategoriaId() != null) {
            categoria = categoriaRepository.findById(produtoDto.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        }

        ProdutoEntity produto = ProdutoMapper.toEntity(produtoDto , categoria);

        return ProdutoMapper.toResponseDto((produtoRepository.save(produto)));
    }

    public ProdutoResponseDto buscarPorId(Long id) {
        return  produtoRepository.findById(id).map(ProdutoMapper :: toResponseDto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public List<ProdutoResponseDto> buscarTodos() {
        return produtoRepository.findAll().stream()
                .map(ProdutoMapper:: toResponseDto )
                .collect(Collectors.toList());
    }
    public List<ProdutoResponseDto> buscarComFiltros(String nome, BigDecimal min, BigDecimal max) {
        return produtoRepository.buscarComFiltros(nome, min, max).stream()
                .map(ProdutoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
    public List<ProdutoResponseDto> buscarPorCategoriaComFiltros(Long categoriaId , String nome, BigDecimal min, BigDecimal max) {
        return produtoRepository.buscarPorCategoriaComFiltros(categoriaId,nome, min, max).stream()
                .map(ProdutoMapper :: toResponseDto )
                .collect(Collectors.toList());
    }



    public ProdutoResponseDto atualizar(Long id, ProdutoRequestDto produtoDto) {
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        CategoriaEntity categoria = null;
        if (produtoDto.getCategoriaId() != null) {
            categoria = categoriaRepository.findById(produtoDto.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        }

        ProdutoMapper.updateEntity(produto , produtoDto, categoria);

        return ProdutoMapper.toResponseDto(produtoRepository.save(produto));
    }

    public List<ProdutoResponseDto> buscarPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId).stream()
                .map(ProdutoMapper :: toResponseDto)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.deleteById(id);
    }
}
