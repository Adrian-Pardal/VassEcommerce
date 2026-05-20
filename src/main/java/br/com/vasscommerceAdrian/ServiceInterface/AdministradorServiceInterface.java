package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.AdministradorRequestDto;
import br.com.vasscommerceAdrian.dto.AdministradorResponseDto;

import java.util.List;


public interface AdministradorServiceInterface {

    public AdministradorResponseDto inserir(AdministradorRequestDto dto) ;

    public List<AdministradorResponseDto> buscarTodos() ;

    public AdministradorResponseDto buscarPorId(Long id) ;

    public AdministradorResponseDto atualizar(Long id, AdministradorRequestDto dto) ;

    public void deletar(Long id) ;
}
