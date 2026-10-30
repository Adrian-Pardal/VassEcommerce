package br.com.vasscommerceAdrian;

import br.com.vasscommerceAdrian.entity.PedidoStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PedidoStatus - fluxo de status do pedido")
class PedidoStatusTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "AGUARDANDO_PAGAMENTO, SEPARANDO_ESTOQUE",
            "SEPARANDO_ESTOQUE, ENTREGUE_TRANSPORTADORA",
            "ENTREGUE_TRANSPORTADORA, ENTREGUE_CLIENTE"
    })
    @DisplayName("Deve avançar para o próximo status na ordem correta")
    void deveAvancarParaProximoStatus(PedidoStatus atual, PedidoStatus esperado) {
        assertEquals(esperado, atual.proximo());
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar avançar do status final")
    void deveLancarExcecaoNoStatusFinal() {
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> PedidoStatus.ENTREGUE_CLIENTE.proximo());

        assertTrue(ex.getMessage().contains("status final"));
    }

    @Test
    @DisplayName("Códigos dos status devem ser sequenciais de 1 a 4")
    void codigosDevemSerSequenciais() {
        PedidoStatus[] valores = PedidoStatus.values();
        for (int i = 0; i < valores.length; i++) {
            assertEquals(i + 1, valores[i].getCodigo());
        }
    }
}