package br.com.vasscommerceAdrian.ServiceInterface;

import br.com.vasscommerceAdrian.dto.FormaPagamentoRequestDto;
import br.com.vasscommerceAdrian.dto.FormaPagamentoResponseDto;
import java.util.List;


public interface FormaPagamentoServiceInterface {

    public List<FormaPagamentoResponseDto> listarPorCliente(Long clienteId) ;

    public FormaPagamentoResponseDto inserir(Long clienteId, FormaPagamentoRequestDto dto) ;

    public FormaPagamentoResponseDto atualizar(Long clienteId, Long id, FormaPagamentoRequestDto dto) ;

    public void deletar(Long clienteId, Long id) ;
}
