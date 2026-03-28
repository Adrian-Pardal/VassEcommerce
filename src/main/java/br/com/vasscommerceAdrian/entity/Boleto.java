package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "boleto")
@DiscriminatorValue("BOLETO")
public class Boleto extends FormaPagamento {

    private String codigoBarras;
    private LocalDate dataVencimento;

    public Boleto() {}

    public String getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(String codigoBarras) { this.codigoBarras = codigoBarras; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }
}
