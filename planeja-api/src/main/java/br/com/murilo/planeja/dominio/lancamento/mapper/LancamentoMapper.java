package br.com.murilo.planeja.dominio.lancamento.mapper;

import br.com.murilo.planeja.dominio.cartao.model.CartaoEntity;
import br.com.murilo.planeja.dominio.categoria.model.CategoriaEntity;
import br.com.murilo.planeja.dominio.lancamento.dto.LancamentoDetalhes;
import br.com.murilo.planeja.dominio.lancamento.dto.LancamentoForm;
import br.com.murilo.planeja.dominio.lancamento.model.LancamentoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    LancamentoEntity toEntity(LancamentoForm form, CategoriaEntity categoria, CartaoEntity cartao);

    LancamentoDetalhes toDetalhes(LancamentoEntity entity);
}
