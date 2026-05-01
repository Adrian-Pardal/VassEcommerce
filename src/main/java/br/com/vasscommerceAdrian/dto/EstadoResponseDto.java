package br.com.vasscommerceAdrian.dto;

import jakarta.validation.constraints.NotBlank;

public class EstadoResponseDto {
    private Long id;
    private String sigla;
    private String nome;

    public EstadoResponseDto() {
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
