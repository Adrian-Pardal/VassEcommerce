package br.com.vasscommerceAdrian.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class EnderecoRequestDto {
    private Long id;
    @NotBlank(message = "Rua não pode estar em branco")
    private String rua;

    @NotBlank
    @NotNull(message = "Número não pode estar em branco")
    private int numero;

    @NotBlank(message = "CEP não pode estar em branco")
    @Size(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
    private String cep;

    @NotBlank(message = "Complemento não pode estar em branco")
    private String complemento;

    @NotBlank
    @NotNull(message = "Telefone não pode estar em branco")
    @Size(min = 10, max = 11, message = "Telefone deve ter 10 ou 11 caracteres")
    private int telefone;

    @NotBlank(message = "Bairro não pode estar em branco")
    private String bairro;

    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaAtualizacao;

    @NotNull(message = "ID do cliente não pode estar em branco")
    private Long clienteId;

    @NotNull(message = "ID da cidade não pode estar em branco")
    private Long cidadeId;

    public EnderecoRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }
}
