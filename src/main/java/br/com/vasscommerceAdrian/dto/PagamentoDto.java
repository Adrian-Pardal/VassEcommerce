package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.Pagamento;
import java.math.BigDecimal;

public class PagamentoDto {

    private Long formaPagamentoId;
    private BigDecimal valorPago;

    public PagamentoDto() {}

    public PagamentoDto(Pagamento pagamento) {
        this.formaPagamentoId = pagamento.getFormaPagamento().getId();
        this.valorPago = pagamento.getValorPago();
    }

    public Long getFormaPagamentoId() { return formaPagamentoId; }
    public void setFormaPagamentoId(Long formaPagamentoId) { this.formaPagamentoId = formaPagamentoId; }

    public BigDecimal getValorPago() { return valorPago; }
    public void setValorPago(BigDecimal valorPago) { this.valorPago = valorPago; }
}
