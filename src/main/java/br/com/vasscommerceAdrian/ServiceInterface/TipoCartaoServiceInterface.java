package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.TipoCartaoRequestDto;
import br.com.vasscommerceAdrian.dto.TipoCartaoResponseDto;

import java.util.List;

public interface TipoCartaoServiceInterface {

    public TipoCartaoResponseDto inserir(TipoCartaoRequestDto dto) ;

    public List<TipoCartaoResponseDto> buscar();

    public TipoCartaoResponseDto buscarPorId(Long id) ;

    public void deletar(Long id) ;
}
