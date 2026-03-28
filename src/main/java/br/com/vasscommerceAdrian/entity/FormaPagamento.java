package br.com.vasscommerceAdrian.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "forma_pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", insertable = false, updatable = false)
    private TipoFormaPagamento tipo;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean excluido = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoFormaPagamento getTipo() { return tipo; }
    public void setTipo(TipoFormaPagamento tipo) { this.tipo = tipo; }

    public boolean isExcluido() { return excluido; }
    public void setExcluido(boolean excluido) { this.excluido = excluido; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }


}
