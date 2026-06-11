package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.CategoriaRequestDto;
import br.com.vasscommerceAdrian.dto.CategoriaResponseDto;

import java.util.List;


public interface CategoriaServiceInterface {

    public CategoriaResponseDto inserir(CategoriaRequestDto categoria);

    public List<CategoriaResponseDto> buscarTodos();

    public CategoriaResponseDto buscarPorNome(String nome) ;

    public CategoriaResponseDto buscarPorId(Long id);

    public void deletar(Long id);

    public CategoriaResponseDto atualizar(Long id, CategoriaRequestDto categoriaDto);
}
