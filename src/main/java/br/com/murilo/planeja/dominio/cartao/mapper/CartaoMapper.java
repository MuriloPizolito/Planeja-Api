package br.com.murilo.planeja.dominio.cartao.mapper;

import br.com.murilo.planeja.dominio.cartao.dto.CartaoDetalhes;
import br.com.murilo.planeja.dominio.cartao.dto.CartaoForm;
import br.com.murilo.planeja.dominio.cartao.model.CartaoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartaoMapper {

    CartaoEntity toEntity(CartaoForm form);

    CartaoDetalhes toDetalhes(CartaoEntity entity);
}
