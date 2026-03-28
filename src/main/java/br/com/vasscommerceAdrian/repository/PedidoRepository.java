package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
    List<Pedido> findByClienteIdAndDataCadastroBetween(Long clienteId, LocalDateTime dataInicio, LocalDateTime dataFim);
}
