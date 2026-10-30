package br.com.vasscommerceAdrian;

import br.com.vasscommerceAdrian.dto.ItemPedidoDto;
import br.com.vasscommerceAdrian.dto.PagamentoDto;
import br.com.vasscommerceAdrian.dto.PedidoRequestDto;
import br.com.vasscommerceAdrian.dto.PedidoResponseDto;
import br.com.vasscommerceAdrian.entity.*;
import br.com.vasscommerceAdrian.repository.ClienteRepository;
import br.com.vasscommerceAdrian.repository.FormaPagamentoRepository;
import br.com.vasscommerceAdrian.repository.PedidoRepository;
import br.com.vasscommerceAdrian.repository.ProdutoRepository;
import br.com.vasscommerceAdrian.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("PedidoService - regras de negócio do pedido")
class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private ProdutoRepository produtoRepository;
    @Mock
    private FormaPagamentoRepository formaPagamentoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    private ClienteEntity cliente;
    private ProdutoEntity produto;
    private Pix pix;

    @BeforeEach
    void setUp() {
        cliente = new ClienteEntity();
        cliente.setId(1L);

        produto = new ProdutoEntity();
        produto.setId(10L);
        produto.setNome("Teclado");
        produto.setValorUnitario(new BigDecimal("50.00"));

        pix = new Pix();
        pix.setId(100L);
        pix.setCliente(cliente);
    }

    /**
     * Monta um pedido: 1 produto (id 10) com a quantidade informada e 1 pagamento (id 100).
     */
    private PedidoRequestDto montarPedido(int quantidade, String valorPago) {
        ItemPedidoDto item = new ItemPedidoDto();
        item.setProdutoId(10L);
        item.setQuantidade(quantidade);

        PagamentoDto pagamento = new PagamentoDto();
        pagamento.setFormaPagamentoId(100L);
        pagamento.setValorPago(new BigDecimal(valorPago));

        PedidoRequestDto dto = new PedidoRequestDto();
        dto.setClienteId(1L);
        dto.setItens(List.of(item));
        dto.setPagamentos(List.of(pagamento));
        return dto;
    }

    @Nested
    @DisplayName("criar()")
    class Criar {
        @Test
        @DisplayName("Deve criar pedido e calcular o valor total (preço x quantidade)")
        void deveCriarPedidoComValorTotalCorreto() {
            when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
            when(produtoRepository.findById(10L)).thenReturn(Optional.of(produto));
            when(formaPagamentoRepository.findById(100L)).thenReturn(Optional.of(pix));
            when(pedidoRepository.save(any(Pedido.class))).thenAnswer(inv -> inv.getArgument(0));

            PedidoResponseDto resposta = pedidoService.criar(montarPedido(3, "150.00"));

            assertEquals(0, new BigDecimal("150.00").compareTo(resposta.getValorTotal()));
            assertEquals("AGUARDANDO_PAGAMENTO", resposta.getStatus());
            verify(pedidoRepository, times(1)).save(any(Pedido.class));
        }

        @Test
        @DisplayName("Deve lançar exceção quando o valor pago for menor que o total")
        void deveFalharComPagamentoInsuficiente() {
            when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
            when(produtoRepository.findById(10L)).thenReturn(Optional.of(produto));
            RuntimeException ex = assertThrows(RuntimeException.class,
                    () -> pedidoService.criar(montarPedido(3, "100.00")));
        }
    }
}