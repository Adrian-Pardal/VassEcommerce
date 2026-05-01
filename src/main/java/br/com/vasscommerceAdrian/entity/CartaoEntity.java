package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "cartao")
@DiscriminatorValue("CARTAO")
public class CartaoEntity extends FormaPagamentoEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_cartao_id")
    private TipoCartaoEntity tipoCartao;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public CartaoEntity() {}

    public TipoCartaoEntity getTipoCartao() { return tipoCartao; }
    public void setTipoCartao(TipoCartaoEntity tipoCartao) { this.tipoCartao = tipoCartao; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
