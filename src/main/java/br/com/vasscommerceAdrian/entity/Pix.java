package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pix")
@DiscriminatorValue("PIX")
public class Pix extends FormaPagamentoEntity {

    private String chavePix;

    public Pix() {}

    public String getChavePix() { return chavePix; }
    public void setChavePix(String chavePix) { this.chavePix = chavePix; }
}
