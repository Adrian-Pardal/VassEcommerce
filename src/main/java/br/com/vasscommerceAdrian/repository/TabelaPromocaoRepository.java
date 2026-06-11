package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.TabelaPromocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaPromocaoRepository extends JpaRepository<TabelaPromocao, Long> {
}
