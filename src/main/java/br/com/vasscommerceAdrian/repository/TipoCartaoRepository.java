package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.TipoCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCartaoRepository extends JpaRepository<TipoCartao, Long> {
}
