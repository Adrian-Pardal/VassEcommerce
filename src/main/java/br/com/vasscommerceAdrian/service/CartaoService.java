package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.ServiceInterface.CartaoServiceInterface;
import br.com.vasscommerceAdrian.dto.CartaoRequestDto;
import br.com.vasscommerceAdrian.dto.CartaoResponseDto;
import br.com.vasscommerceAdrian.entity.CartaoEntity;
import br.com.vasscommerceAdrian.entity.ClienteEntity;
import br.com.vasscommerceAdrian.entity.TipoCartaoEntity;
import br.com.vasscommerceAdrian.mapper.CartaoMapper;
import br.com.vasscommerceAdrian.repository.CartaoRepository;
import br.com.vasscommerceAdrian.repository.ClienteRepository;
import br.com.vasscommerceAdrian.repository.TipoCartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartaoService implements CartaoServiceInterface {

    @Autowired private CartaoRepository cartaoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private TipoCartaoRepository tipoCartaoRepository;

    @Override
    public CartaoResponseDto criar(CartaoRequestDto dto) {
        ClienteEntity cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        TipoCartaoEntity tipoCartao = tipoCartaoRepository.findById(dto.getTipoCartaoId())
                .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));

        CartaoEntity cartao = CartaoMapper.toEntity(dto , cliente , tipoCartao);
        return new CartaoResponseDto(cartaoRepository.save(cartao));
    }

    @Override
    public List<CartaoResponseDto> listarPorCliente(Long clienteId) {
        return cartaoRepository.findByClienteId(clienteId).stream()
                .filter(c -> !c.isExcluido())
                .map(CartaoMapper :: toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CartaoResponseDto buscarPorId(Long id) {
        return new CartaoResponseDto(cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado")));
    }

    @Override
    public CartaoResponseDto atualizar(Long id, CartaoRequestDto dto) {
        CartaoEntity cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        TipoCartaoEntity tipoCartao = null;
        if (dto.getTipoCartaoId() != null) {
            tipoCartao = tipoCartaoRepository.findById(dto.getTipoCartaoId())
                    .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));
        }

        ClienteEntity cliente =  null;
        if(dto.getClienteId() != null){
            cliente = clienteRepository.findById(dto.getClienteId())
                    .orElseThrow( () -> new RuntimeException("Cliente não encontrado"));
        }
        CartaoMapper.updateEntity(cartao , dto , tipoCartao , cliente);

        CartaoEntity salvo = cartaoRepository.save(cartao);

        return CartaoMapper.toResponseDto(salvo);
    }

    @Override
    public void deletar(Long id) {
        CartaoEntity cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
        cartao.setExcluido(true);
        cartaoRepository.save(cartao);
    }
}



