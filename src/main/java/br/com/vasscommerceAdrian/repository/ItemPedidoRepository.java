package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
