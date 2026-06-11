package br.com.vasscommerceAdrian.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CidadeRequestDto {
    private Long id;
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;
    @NotNull(message = "O campo estadoId é obrigatório")
    private Long estadoId;

    public CidadeRequestDto() {
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

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}
