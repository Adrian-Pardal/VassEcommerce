package br.com.vasscommerceAdrian.dto;

import br.com.vasscommerceAdrian.entity.*;
import java.time.LocalDate;

public class FormaPagamentoDto {

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

    public FormaPagamentoDto() {}

    public FormaPagamentoDto(FormaPagamento forma) {
        this.id = forma.getId();
        this.tipo = forma.getTipo();
        this.excluido = forma.isExcluido();

        if (forma instanceof Cartao c) {
            if (c.getTipoCartao() != null) {
                this.tipoCartaoId = c.getTipoCartao().getId();
                this.tipoCartaoDescricao = c.getTipoCartao().getDescricao();
            }
        } else if (forma instanceof Pix p) {
            this.chavePix = p.getChavePix();
        } else if (forma instanceof Boleto b) {
            this.codigoBarras = b.getCodigoBarras();
            this.dataVencimento = b.getDataVencimento();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoFormaPagamento getTipo() { return tipo; }
    public void setTipo(TipoFormaPagamento tipo) { this.tipo = tipo; }

    public boolean isExcluido() { return excluido; }
    public void setExcluido(boolean excluido) { this.excluido = excluido; }

    public Long getTipoCartaoId() { return tipoCartaoId; }
    public void setTipoCartaoId(Long tipoCartaoId) { this.tipoCartaoId = tipoCartaoId; }

    public String getTipoCartaoDescricao() { return tipoCartaoDescricao; }
    public void setTipoCartaoDescricao(String tipoCartaoDescricao) { this.tipoCartaoDescricao = tipoCartaoDescricao; }

    public String getChavePix() { return chavePix; }
    public void setChavePix(String chavePix) { this.chavePix = chavePix; }

    public String getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(String codigoBarras) { this.codigoBarras = codigoBarras; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }
}
