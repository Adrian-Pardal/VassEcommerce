package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.TipoCartao;

public class TipoCartaoDto {

    private Long id;
    private String descricao;

    public TipoCartaoDto() {}

    public TipoCartaoDto(TipoCartao tipoCartao) {
        this.id = tipoCartao.getId();
        this.descricao = tipoCartao.getDescricao();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
