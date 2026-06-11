package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.ItemPedidoDto;
import br.com.vasscommerceAdrian.dto.PagamentoDto;
import br.com.vasscommerceAdrian.dto.PedidoRequestDto;
import br.com.vasscommerceAdrian.dto.PedidoResponseDto;
import br.com.vasscommerceAdrian.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    private PedidoMapper() {}

    public static Pedido toEntity(PedidoRequestDto dto, ClienteEntity cliente,
                                  List<ItemPedido> itens, List<Pagamento> pagamentos) {
        Pedido entity = new Pedido();

        entity.setCliente(cliente);
        entity.setValorTotal(dto.getValorTotal());
        entity.setStatus(PedidoStatus.AGUARDANDO_PAGAMENTO);

        if (itens != null) {
            itens.forEach(item -> item.setPedido(entity));
            entity.setItens(itens);
        }

        if (pagamentos != null) {
            pagamentos.forEach(pag -> pag.setPedido(entity));
            entity.setPagamentos(pagamentos);
        }

        return entity;
    }

    public static PedidoResponseDto toResponseDto(Pedido entity) {
        PedidoResponseDto responseDto = new PedidoResponseDto();

        responseDto.setId(entity.getId());
        responseDto.setDataCadastro(entity.getDataCadastro());
        responseDto.setValorTotal(entity.getValorTotal());
        responseDto.setStatus(entity.getStatus().name());

        if (entity.getCliente() != null)
            responseDto.setClienteId(entity.getCliente().getId());

        if (entity.getItens() != null)
            responseDto.setItens(entity.getItens().stream()
                    .map(ItemPedidoDto::new)
                    .collect(Collectors.toList()));

        if (entity.getPagamentos() != null)
            responseDto.setPagamentos(entity.getPagamentos().stream()
                    .map(PagamentoDto::new)
                    .collect(Collectors.toList()));

        return responseDto;
    }

    public static void updateEntity(Pedido entity, PedidoStatus novoStatus) {
        if (novoStatus != null)
            entity.setStatus(novoStatus);
    }
}
