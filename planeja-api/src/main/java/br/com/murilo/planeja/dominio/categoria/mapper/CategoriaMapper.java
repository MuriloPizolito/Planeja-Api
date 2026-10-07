package br.com.murilo.planeja.dominio.categoria.mapper;

import br.com.murilo.planeja.dominio.categoria.dto.CategoriaDetalhes;
import br.com.murilo.planeja.dominio.categoria.dto.CategoriaForm;
import br.com.murilo.planeja.dominio.categoria.model.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaEntity toEntity(CategoriaForm nova);

    CategoriaDetalhes toDetalhes(CategoriaEntity entity);
}
