package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.TabelaPromocaoRequestDto;
import br.com.vasscommerceAdrian.dto.TabelaPromocaoResponseDto;
import java.util.List;


public interface TabelaPromocaoServiceInterface {

    public TabelaPromocaoResponseDto inserir(TabelaPromocaoRequestDto dto) ;

    public List<TabelaPromocaoResponseDto> buscar() ;

    public TabelaPromocaoResponseDto buscarPorId(Long id) ;

    public TabelaPromocaoResponseDto atualizar(Long id, TabelaPromocaoRequestDto dto) ;

    public void deletar(Long id) ;
}
