package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.EstadoRequestDto;
import br.com.vasscommerceAdrian.dto.EstadoResponseDto;

import java.util.List;

public interface EstadoServiceInterface {

    public EstadoResponseDto inserir(EstadoRequestDto estadoDto) ;

    public EstadoResponseDto buscarPorId(Long id) ;

    public List<EstadoResponseDto> buscarTodos() ;

    public EstadoResponseDto atualizar(Long id, EstadoRequestDto estadoDto) ;

    public void deletar(Long id) ;
}
