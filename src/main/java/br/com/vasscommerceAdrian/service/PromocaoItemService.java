package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.PromocaoItemDto;
import br.com.vasscommerceAdrian.entity.PromocaoItem;
import br.com.vasscommerceAdrian.entity.ProdutoEntity;
import br.com.vasscommerceAdrian.entity.TabelaPromocao;
import br.com.vasscommerceAdrian.repository.PromocaoItemRepository;
import br.com.vasscommerceAdrian.repository.ProdutoRepository;
import br.com.vasscommerceAdrian.repository.TabelaPromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocaoItemService {

    @Autowired
    private PromocaoItemRepository promocaoItemRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private TabelaPromocaoRepository tabelaPromocaoRepository;

    public PromocaoItem inserir(Long promocaoId, PromocaoItemDto dto) {
        ProdutoEntity produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        TabelaPromocao promocao = tabelaPromocaoRepository.findById(promocaoId)
                .orElseThrow(() -> new RuntimeException("Promoção não encontrada"));

        PromocaoItem item = new PromocaoItem();
        item.setProduto(produto);
        item.setTabelaPromocao(promocao);
        item.setValorPromocao(dto.getValorPromocao());
        return promocaoItemRepository.save(item);
    }

    public List<PromocaoItem> buscarPorPromocao(Long promocaoId) {
        return promocaoItemRepository.findByTabelaPromocaoId(promocaoId);
    }

    public void deletar(Long id) {
        promocaoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de promoção não encontrado"));
        promocaoItemRepository.deleteById(id);
    }
}
