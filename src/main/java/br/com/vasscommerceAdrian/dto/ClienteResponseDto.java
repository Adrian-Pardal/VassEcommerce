package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteResponseDto {

    private Long id;
    private String nomeCompleto;
    private String email;
    private String fotoUrl;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;

    public ClienteResponseDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.email = cliente.getEmail();
        this.fotoUrl = cliente.getFotoUrl();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.dataCadastro = cliente.getDataCadastro();
    }

    public Long getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getEmail() { return email; }
    public String getFotoUrl() { return fotoUrl; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
}
