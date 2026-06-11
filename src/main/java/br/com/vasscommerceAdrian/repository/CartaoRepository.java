package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {
    List<CartaoEntity> findByClienteId(Long clienteId);
}
