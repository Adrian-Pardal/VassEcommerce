package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.CartaoEntity;
import br.com.vasscommerceAdrian.entity.TipoCartaoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CartaoRequestDto {

    private Long id;

    @NotNull(message = "ID do cliente não pode estar em branco")
    private Long clienteId;
    private boolean excluido;

    @NotNull(message = "Número do cartão não pode estar em branco")
    private Long tipoCartaoId;

    @NotBlank(message = "Descrição do tipo do cartão não pode estar em branco")
    private String tipoCartaoDescricao;

    @NotBlank(message = "Titular não pode estar em branco")
    private String titular;
    private LocalDateTime dataCriacao;

    public CartaoRequestDto() {}

    public CartaoRequestDto(CartaoEntity cartao) {
        this.id = cartao.getId();
        this.excluido = cartao.isExcluido();
        this.dataCriacao = cartao.getDataCriacao();
        if (cartao.getCliente() != null) {
            this.clienteId = cartao.getCliente().getId();
            this.titular = cartao.getCliente().getNomeCompleto();
        }
        if (cartao.getTipoCartao() != null) {
            this.tipoCartaoId = cartao.getTipoCartao().getId();
            this.tipoCartaoDescricao = cartao.getTipoCartao().getDescricao();
        }
    }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isExcluido() { return excluido; }
    public void setExcluido(boolean excluido) { this.excluido = excluido; }

    public Long getTipoCartaoId() { return tipoCartaoId; }
    public void setTipoCartaoId(Long tipoCartaoId) { this.tipoCartaoId = tipoCartaoId; }

    public String getTipoCartaoDescricao() { return tipoCartaoDescricao; }
    public void setTipoCartaoDescricao(String tipoCartaoDescricao) { this.tipoCartaoDescricao = tipoCartaoDescricao; }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
