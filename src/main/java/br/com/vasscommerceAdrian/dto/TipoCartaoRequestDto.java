package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.TipoCartaoEntity;
import jakarta.validation.constraints.NotBlank;

public class TipoCartaoRequestDto {

    private Long id;
    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    public TipoCartaoRequestDto() {}

    public TipoCartaoRequestDto(TipoCartaoEntity tipoCartao) {
        this.id = tipoCartao.getId();
        this.descricao = tipoCartao.getDescricao();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
