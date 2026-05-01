package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.FormaPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamentoEntity, Long> {
    List<FormaPagamentoEntity> findByClienteId(Long clienteId);
}
