package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.CategoriaEntity;
import org.springframework.beans.BeanUtils;

public class CategoriaDto {
    private Long id;
    private String nome;
    private String imagemSimboloUM;
    private String descricao;

    public CategoriaDto(CategoriaEntity categoria) {
        BeanUtils.copyProperties(categoria , this);
    }

    public CategoriaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemSimboloUM() {
        return imagemSimboloUM;
    }

    public void setImagemSimboloUM(String imagemSimboloUM) {
        this.imagemSimboloUM = imagemSimboloUM;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
