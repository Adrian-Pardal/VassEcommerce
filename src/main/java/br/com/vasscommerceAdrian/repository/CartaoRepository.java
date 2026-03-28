package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    List<Cartao> findByClienteId(Long clienteId);
}
