package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.ProdutoRequestDto;
import br.com.vasscommerceAdrian.dto.ProdutoResponseDto;
import br.com.vasscommerceAdrian.mapper.ProdutoMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


public interface ProdutoServiceInterface {

    public ProdutoResponseDto inserir(ProdutoRequestDto produtoDto) ;

    public ProdutoResponseDto buscarPorId(Long id) ;

    public List<ProdutoResponseDto> buscarTodos() ;
    public List<ProdutoResponseDto> buscarComFiltros(String nome, BigDecimal min, BigDecimal max) ;

    public List<ProdutoResponseDto> buscarPorCategoriaComFiltros(Long categoriaId , String nome, BigDecimal min, BigDecimal max) ;

    public ProdutoResponseDto atualizar(Long id, ProdutoRequestDto produtoDto) ;

    public List<ProdutoResponseDto> buscarPorCategoria(Long categoriaId);

    public void deletar(Long id) ;
}
