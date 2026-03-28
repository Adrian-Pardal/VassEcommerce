package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.ProdutoDto;
import br.com.vasscommerceAdrian.entity.CategoriaEntity;
import br.com.vasscommerceAdrian.entity.ProdutoEntity;
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

    public ProdutoDto inserir(ProdutoDto produtoDto) {
        ProdutoEntity produto = new ProdutoEntity();
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setFotoUrl(produtoDto.getFotoUrl());
        produto.setValorUnitario(produtoDto.getValorUnitario());

        if (produtoDto.getCategoriaId() != null) {
            CategoriaEntity categoria = categoriaRepository.findById(produtoDto.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            produto.setCategoria(categoria);
        }

        return new ProdutoDto(produtoRepository.save(produto));
    }

    public ProdutoDto buscarPorId(Long id) {
        return new ProdutoDto(produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado")));
    }

    public List<ProdutoDto> buscarTodos() {
        return produtoRepository.findAll().stream()
                .map(ProdutoDto::new)
                .collect(Collectors.toList());
    }
    public List<ProdutoDto> buscarComFiltros(String nome, BigDecimal min, BigDecimal max) {
        return produtoRepository.buscarComFiltros(nome, min, max).stream()
                .map(ProdutoDto::new)
                .collect(Collectors.toList());
    }
    public List<ProdutoDto> buscarPorCategoriaComFiltros(Long categoriaId , String nome, BigDecimal min, BigDecimal max) {
        return produtoRepository.buscarPorCategoriaComFiltros(categoriaId,nome, min, max).stream()
                .map(ProdutoDto::new)
                .collect(Collectors.toList());
    }



    public ProdutoDto atualizar(Long id, ProdutoDto produtoDto) {
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setFotoUrl(produtoDto.getFotoUrl());
        produto.setValorUnitario(produtoDto.getValorUnitario());

        if (produtoDto.getCategoriaId() != null) {
            CategoriaEntity categoria = categoriaRepository.findById(produtoDto.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            produto.setCategoria(categoria);
        }

        return new ProdutoDto(produtoRepository.save(produto));
    }

    public List<ProdutoDto> buscarPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId).stream()
                .map(ProdutoDto::new)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.deleteById(id);
    }
}
