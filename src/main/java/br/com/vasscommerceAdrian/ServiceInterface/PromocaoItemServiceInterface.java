package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.PromocaoItemRequestDto;
import br.com.vasscommerceAdrian.dto.PromocaoItemResponseDto;
import java.util.List;


public interface PromocaoItemServiceInterface {

    public PromocaoItemResponseDto inserir(Long promocaoId, PromocaoItemRequestDto dto) ;

    public List<PromocaoItemResponseDto> buscarPorPromocao(Long promocaoId) ;

    public void deletar(Long id) ;
}
