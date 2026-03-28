package br.com.vasscommerceAdrian.service;

import br.com.vasscommerceAdrian.dto.TabelaPromocaoDto;
import br.com.vasscommerceAdrian.entity.TabelaPromocao;
import br.com.vasscommerceAdrian.repository.TabelaPromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabelaPromocaoService {

    @Autowired
    private TabelaPromocaoRepository tabelaPromocaoRepository;

    public TabelaPromocao inserir(TabelaPromocaoDto dto) {
        TabelaPromocao promocao = new TabelaPromocao();
        promocao.setNome(dto.getNome());
        promocao.setDescricao(dto.getDescricao());
        promocao.setDataInicio(dto.getDataInicio());
        promocao.setDataFim(dto.getDataFim());
        return tabelaPromocaoRepository.save(promocao);
    }

    public List<TabelaPromocao> buscar() {
        return tabelaPromocaoRepository.findAll();
    }

    public TabelaPromocao buscarPorId(Long id) {
        return tabelaPromocaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoção não encontrada"));
    }

    public TabelaPromocao atualizar(Long id, TabelaPromocaoDto dto) {
        TabelaPromocao promocao = buscarPorId(id);
        promocao.setNome(dto.getNome());
        promocao.setDescricao(dto.getDescricao());
        promocao.setDataInicio(dto.getDataInicio());
        promocao.setDataFim(dto.getDataFim());
        return tabelaPromocaoRepository.save(promocao);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        tabelaPromocaoRepository.deleteById(id);
    }


}
