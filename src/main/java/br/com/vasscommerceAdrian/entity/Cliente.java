package br.com.vasscommerceAdrian.entity;

import br.com.vasscommerceAdrian.dto.ClienteDto;
import br.com.vasscommerceAdrian.dto.UsuarioDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity
@Table(name = "cliente")
public class Cliente extends UsuarioEntity{

    private String cpf;
    private LocalDate dataNascimento;

    public Cliente(ClienteDto clienteDto) {

        super(clienteDto); // copia dados de Usuario

        this.cpf = clienteDto.getCpf();
        this.dataNascimento = clienteDto.getDataNascimento();
    }


    public Cliente(){

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
