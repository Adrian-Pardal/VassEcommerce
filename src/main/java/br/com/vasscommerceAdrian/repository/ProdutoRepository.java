package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    @Query("""
        SELECT p FROM ProdutoEntity p 
        WHERE (:nome IS NULL OR LOWER(p.nome) LIKE LOWER(CONCAT('%' , :nome , '%')))
        AND (:min IS NULL OR p.valorUnitario >= :min)
        AND (:max IS NULL OR p.valorUnitario <= :max)       
    """
    )
    List<ProdutoEntity> buscarComFiltros(
            @Param("nome") String nome,
            @Param("min")BigDecimal min,
            @Param("max") BigDecimal max
    );

    @Query("""
        SELECT p FROM ProdutoEntity p 
        WHERE p.categoria.id = :categoriaId
        AND (:nome IS NULL OR LOWER(p.nome) LIKE LOWER(CONCAT('%' , :nome , '%')))
        AND (:min IS NULL OR p.valorUnitario >= :min)
        AND (:max IS NULL OR p.valorUnitario <= :max)       
    """
    )
    List<ProdutoEntity> buscarPorCategoriaComFiltros(
            @Param("categoriaId") Long categoriaId,
            @Param("nome") String nome,
            @Param("min")BigDecimal min,
            @Param("max") BigDecimal max
    );


    List<ProdutoEntity> findByCategoriaId(Long categoriaId);
}
