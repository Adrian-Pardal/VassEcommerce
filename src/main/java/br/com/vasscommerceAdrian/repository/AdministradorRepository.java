package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Long> {
}
