package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.AdministradorEntity;

import java.time.LocalDateTime;

public class AdministradorResponseDto {

    private Long id;
    private String nomeCompleto;
    private String email;
    private String fotoUrl;
    //private LocalDateTime dataCadastro;

    public AdministradorResponseDto() {
        //this.id = administrador.getId();
        //this.nomeCompleto = administrador.getNomeCompleto();
        //this.email = administrador.getEmail();
        //this.fotoUrl = administrador.getFotoUrl();
        //this.dataCadastro = administrador.getDataCadastro();
    }

    public Long getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getEmail() { return email; }
    public String getFotoUrl() { return fotoUrl; }
    //public LocalDateTime getDataCadastro() { return dataCadastro; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }


}
