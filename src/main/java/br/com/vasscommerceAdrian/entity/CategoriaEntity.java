package br.com.vasscommerceAdrian.entity;

import br.com.vasscommerceAdrian.dto.CategoriaRequestDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String imagemSimboloUM;
    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProdutoEntity> produtos;

    public CategoriaEntity() {

    }

    public CategoriaEntity(CategoriaRequestDto dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.imagemSimboloUM = dto.getImagemSimboloUM();
        this.descricao = dto.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemSimboloUM() {
        return imagemSimboloUM;
    }

    public void setImagemSimboloUM(String imagemSimboloUM) {
        this.imagemSimboloUM = imagemSimboloUM;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
