package br.com.vasscommerceAdrian.repository;

import br.com.vasscommerceAdrian.entity.PromocaoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocaoItemRepository extends JpaRepository<PromocaoItem, Long> {
    List<PromocaoItem> findByTabelaPromocaoId(Long tabelaPromocaoId);
}
