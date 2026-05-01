package br.com.vasscommerceAdrian.dto;

import jakarta.validation.constraints.NotBlank;

public class EstadoRequestDto {
    private Long id;

    @NotBlank(message = "Sigla é obrigatória")
    private String sigla;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    public EstadoRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
