package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> {
    List<CidadeEntity> findByEstadoId(Long estadoId);
}
