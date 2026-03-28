package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.CartaoDto;
import br.com.vasscommerceAdrian.entity.Cartao;
import br.com.vasscommerceAdrian.entity.Cliente;
import br.com.vasscommerceAdrian.entity.TipoCartao;
import br.com.vasscommerceAdrian.repository.CartaoRepository;
import br.com.vasscommerceAdrian.repository.ClienteRepository;
import br.com.vasscommerceAdrian.repository.TipoCartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartaoService {

    @Autowired private CartaoRepository cartaoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private TipoCartaoRepository tipoCartaoRepository;

    public CartaoDto criar(CartaoDto dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        TipoCartao tipoCartao = tipoCartaoRepository.findById(dto.getTipoCartaoId())
                .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));

        Cartao cartao = new Cartao();
        cartao.setCliente(cliente);
        cartao.setTipoCartao(tipoCartao);
        return new CartaoDto(cartaoRepository.save(cartao));
    }

    public List<CartaoDto> listarPorCliente(Long clienteId) {
        return cartaoRepository.findByClienteId(clienteId).stream()
                .filter(c -> !c.isExcluido())
                .map(CartaoDto::new)
                .collect(Collectors.toList());
    }

    public CartaoDto buscarPorId(Long id) {
        return new CartaoDto(cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado")));
    }

    public CartaoDto atualizar(Long id, CartaoDto dto) {
        Cartao cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
        if (dto.getTipoCartaoId() != null) {
            TipoCartao tipoCartao = tipoCartaoRepository.findById(dto.getTipoCartaoId())
                    .orElseThrow(() -> new RuntimeException("TipoCartao não encontrado"));
            cartao.setTipoCartao(tipoCartao);
        }
        return new CartaoDto(cartaoRepository.save(cartao));
    }

    public void deletar(Long id) {
        Cartao cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
        cartao.setExcluido(true);
        cartaoRepository.save(cartao);
    }
}



