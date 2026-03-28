package br.com.vasscommerceAdrian.entity;

public enum PedidoStatus {

    AGUARDANDO_PAGAMENTO(1),
    SEPARANDO_ESTOQUE(2),
    ENTREGUE_TRANSPORTADORA(3),
    ENTREGUE_CLIENTE(4);

    private final int codigo;

    PedidoStatus(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public PedidoStatus proximo() {
        PedidoStatus[] values = PedidoStatus.values();
        if (this.codigo < values.length)
            return values[this.codigo];
        throw new RuntimeException("Pedido já está no status final: " + this.name());
    }
}
