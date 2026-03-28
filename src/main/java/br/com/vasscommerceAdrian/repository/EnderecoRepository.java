package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
    List<EnderecoEntity> findByClienteId(Long clienteId);
}
