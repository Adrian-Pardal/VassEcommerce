package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Long> {
}
