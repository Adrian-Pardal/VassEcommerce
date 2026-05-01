package br.com.vasscommerceAdrian.mapper;

import br.com.vasscommerceAdrian.dto.FormaPagamentoRequestDto;
import br.com.vasscommerceAdrian.dto.FormaPagamentoResponseDto;
import br.com.vasscommerceAdrian.entity.*;

public class FormaPagamentoMapper {
    private FormaPagamentoMapper() {
    }

    public static FormaPagamentoEntity toEntity(FormaPagamentoRequestDto dto,
                                                ClienteEntity cliente,
                                                TipoCartaoEntity tipoCartao) {

        FormaPagamentoEntity forma;

        switch (dto.getTipo()) {

            case CARTAO -> {
                CartaoEntity c = new CartaoEntity();
                if (tipoCartao != null) {
                    c.setTipoCartao(tipoCartao);
                }
                forma = c;
            }

            case PIX -> {
                Pix p = new Pix();
                p.setChavePix(dto.getChavePix());
                forma = p;
            }

            case BOLETO -> {
                Boleto b = new Boleto();
                b.setCodigoBarras(dto.getCodigoBarras());
                b.setDataVencimento(dto.getDataVencimento());
                forma = b;
            }

            default -> throw new RuntimeException("Tipo inválido");
        }

        forma.setCliente(cliente);
        forma.setExcluido(false);

        return forma;
    }

    public static FormaPagamentoResponseDto toResponseDto(FormaPagamentoEntity forma) {

        FormaPagamentoResponseDto dto = new FormaPagamentoResponseDto();

        dto.setId(forma.getId());
        dto.setExcluido(forma.isExcluido());

        // 🔥 AQUI ESTÁ A SOLUÇÃO DO TIPO
        dto.setTipo(getTipoFromInstance(forma));

        if (forma instanceof CartaoEntity c) {
            if (c.getTipoCartao() != null) {
                dto.setTipoCartaoId(c.getTipoCartao().getId());
                dto.setTipoCartaoDescricao(c.getTipoCartao().getDescricao());
            }
        }

        if (forma instanceof Pix p) {
            dto.setChavePix(p.getChavePix());
        }

        if (forma instanceof Boleto b) {
            dto.setCodigoBarras(b.getCodigoBarras());
            dto.setDataVencimento(b.getDataVencimento());
        }

        return dto;
    }

    public static void updateEntity(FormaPagamentoEntity forma,
                                    FormaPagamentoRequestDto dto,
                                    TipoCartaoEntity tipoCartao) {

        if (forma instanceof CartaoEntity c) {
            if (tipoCartao != null) {
                c.setTipoCartao(tipoCartao);
            }
        }

        if (forma instanceof Pix p) {
            p.setChavePix(dto.getChavePix());
        }

        if (forma instanceof Boleto b) {
            b.setCodigoBarras(dto.getCodigoBarras());
            b.setDataVencimento(dto.getDataVencimento());
        }
    }

    private static TipoFormaPagamento getTipoFromInstance(FormaPagamentoEntity forma) {

        if (forma instanceof CartaoEntity) return TipoFormaPagamento.CARTAO;
        if (forma instanceof Pix) return TipoFormaPagamento.PIX;
        if (forma instanceof Boleto) return TipoFormaPagamento.BOLETO;

        throw new RuntimeException("Tipo desconhecido");
    }


}
