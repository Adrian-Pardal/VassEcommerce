package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.EnderecoRequestDto;
import br.com.vasscommerceAdrian.dto.EnderecoResponseDto;

import java.util.List;


public interface EnderecoServiceInterface {

    public EnderecoResponseDto inserir(EnderecoRequestDto enderecoDto) ;
    public EnderecoResponseDto buscarPorId(Long id) ;

    public List<EnderecoResponseDto> buscarTodos();

    public EnderecoResponseDto atualizarPorCliente(Long clienteId, Long id, EnderecoRequestDto enderecoDto);
    public EnderecoResponseDto atualizar(Long id, EnderecoRequestDto enderecoDto) ;

    public List<EnderecoResponseDto> buscarPorCliente(Long clienteId);

    public void deletar(Long id) ;

}
