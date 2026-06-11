package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.ClienteRequestDto;
import br.com.vasscommerceAdrian.dto.ClienteResponseDto;

import java.util.List;


public interface ClienteServiceInterface {

    public ClienteResponseDto inserir(ClienteRequestDto clienteDto);

    public List<ClienteResponseDto> buscarTodos();
    public ClienteResponseDto buscarPorId(Long id);

    public void deletar(Long id);

    public ClienteResponseDto atualizar(Long id, ClienteRequestDto clienteDto);
}
