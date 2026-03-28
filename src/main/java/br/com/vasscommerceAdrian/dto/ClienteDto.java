package br.com.vasscommerceAdrian.dto;

import java.time.LocalDate;

public class ClienteDto extends UsuarioDto{



    private String cpf;
    private LocalDate dataNascimento;

    public ClienteDto(String cpf, LocalDate dataNascimento) {
        super();
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public ClienteDto() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
