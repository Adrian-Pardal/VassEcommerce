package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.PedidoStatus;

public class AtualizarStatusDto {

    private PedidoStatus status;

    public AtualizarStatusDto() {}

    public PedidoStatus getStatus() { return status; }
    public void setStatus(PedidoStatus status) { this.status = status; }
}
