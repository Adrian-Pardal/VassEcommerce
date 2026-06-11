package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.CidadeRequestDto;
import br.com.vasscommerceAdrian.dto.CidadeResponseDto;


import java.util.List;


public interface CidadeServiceInterface {

    public CidadeResponseDto inserir(CidadeRequestDto cidadeDto) ;

    public List<CidadeResponseDto> buscarTodos() ;

    public CidadeResponseDto buscarPorId(Long id);

    public CidadeResponseDto atualizar(Long id, CidadeRequestDto cidadeDto);

    public List<CidadeResponseDto> buscarPorEstado(Long estadoId) ;

    public boolean deletar(Long id) ;
}
