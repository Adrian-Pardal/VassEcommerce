package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.PedidoRequestDto;
import br.com.vasscommerceAdrian.dto.PedidoResponseDto;
import br.com.vasscommerceAdrian.entity.*;
import java.time.LocalDateTime;
import java.util.List;


public interface PedidoServiceInterface {

    public PedidoResponseDto criar(PedidoRequestDto dto) ;
    public List<PedidoResponseDto> listarPorCliente(Long clienteId) ;

    public List<PedidoResponseDto> listarPorClienteEPeriodo(Long clienteId, LocalDateTime dataInicio, LocalDateTime dataFim) ;

    public void atualizarStatus(Long pedidoId, PedidoStatus novoStatus) ;
}
