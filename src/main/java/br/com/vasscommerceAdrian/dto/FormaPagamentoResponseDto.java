package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.*;
import java.time.LocalDate;

public class FormaPagamentoResponseDto {

    private Long id;
    private TipoFormaPagamento tipo;
    private boolean excluido;

    // Cartao
    private Long tipoCartaoId;
    private String tipoCartaoDescricao;

    // Pix
    private String chavePix;

    // Boleto
    private String codigoBarras;
    private LocalDate dataVencimento;

    public FormaPagamentoResponseDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoFormaPagamento getTipo() {
        return tipo;
    }
    public void setTipo(TipoFormaPagamento tipo) {
        this.tipo = tipo;
    }

    public boolean isExcluido() {
        return excluido;
    }
    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public Long getTipoCartaoId() {
        return tipoCartaoId;
    }
    public void setTipoCartaoId(Long tipoCartaoId) {
        this.tipoCartaoId = tipoCartaoId;
    }

    public String getTipoCartaoDescricao() {
        return tipoCartaoDescricao;
    }
    public void setTipoCartaoDescricao(String tipoCartaoDescricao) {
        this.tipoCartaoDescricao = tipoCartaoDescricao;
    }

    public String getChavePix() {
        return chavePix;
    }
    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
