package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_cartao")
public class TipoCartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;

    public TipoCartaoEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
