package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rua;
    private int numero;
    private String cep;
    private String complemento;
    private int telefone;
    private String bairro;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaAtualizacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidade_id")
    private CidadeEntity cidade;


    public EnderecoEntity() {
    }

    public CidadeEntity getCidade() {
        return cidade;
    }

    public void setCidade(CidadeEntity cidade) {
        this.cidade = cidade;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
