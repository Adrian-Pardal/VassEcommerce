package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "cartao")
@DiscriminatorValue("CARTAO")
public class Cartao extends FormaPagamento {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_cartao_id")
    private TipoCartao tipoCartao;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public Cartao() {}

    public TipoCartao getTipoCartao() { return tipoCartao; }
    public void setTipoCartao(TipoCartao tipoCartao) { this.tipoCartao = tipoCartao; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
