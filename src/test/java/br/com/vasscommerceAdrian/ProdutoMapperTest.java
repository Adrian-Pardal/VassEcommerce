package br.com.vasscommerceAdrian;

import br.com.vasscommerceAdrian.dto.ProdutoRequestDto;
import br.com.vasscommerceAdrian.entity.CategoriaEntity;
import br.com.vasscommerceAdrian.entity.ProdutoEntity;
import br.com.vasscommerceAdrian.mapper.ProdutoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProdutoMapperTest {

    private CategoriaEntity categoria;

    @BeforeEach
    void setUp() {
        categoria = new CategoriaEntity();
        categoria.setId(7L);
        categoria.setNome("Perifericos");
    }

    private ProdutoRequestDto montarRequestDto() {
        ProdutoRequestDto dto =  new ProdutoRequestDto();
        dto.setNome("Teclado");
        dto.setDescricao("Teclado Mecanico");
        dto.setFotoUrl("http://img/teclado.png");
        dto.setValorUnitario(new BigDecimal("50.00"));
        return dto;
    }

    @Nested
    class ToEntity{
        @Test
        void deveCopiarCamposEAssociarCategoria(){
            ProdutoEntity entity = ProdutoMapper.toEntity(montarRequestDto() , categoria);

            assertEquals("Teclado" , entity.getNome());
            assertEquals("Teclado Mecanico" , entity.getDescricao());
            assertEquals("http://img/teclado.png" , entity.getFotoUrl());
            assertEquals(0 , new BigDecimal("50.00").compareTo(entity.getValorUnitario()));
        }

        @Test
        void naoDevePropagarIdDoDto(){
            ProdutoRequestDto dto = montarRequestDto();
            dto.setId(99L);

            ProdutoEntity entity = ProdutoMapper.toEntity(dto , categoria);

            assertNull(entity.getId() , "o id deve ser gerado pelo banco, nao vir do DTO");
        }
    }
}
