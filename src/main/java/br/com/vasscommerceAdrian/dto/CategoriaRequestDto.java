package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.CategoriaEntity;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

public class CategoriaRequestDto {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String imagemSimboloUM;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    public CategoriaRequestDto(CategoriaEntity categoria) {

    }

    public CategoriaRequestDto() {
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
