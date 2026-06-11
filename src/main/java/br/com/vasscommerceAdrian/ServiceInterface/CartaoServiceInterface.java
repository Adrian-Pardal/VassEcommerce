package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.CartaoRequestDto;
import br.com.vasscommerceAdrian.dto.CartaoResponseDto;

import java.util.List;


public interface CartaoServiceInterface {

    public CartaoResponseDto criar(CartaoRequestDto dto) ;

    public List<CartaoResponseDto> listarPorCliente(Long clienteId) ;

    public CartaoResponseDto buscarPorId(Long id) ;

    public CartaoResponseDto atualizar(Long id, CartaoRequestDto dto) ;

    public void deletar(Long id) ;
}
