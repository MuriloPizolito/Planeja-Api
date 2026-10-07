package br.com.murilo.planeja.dominio.categoria;

import br.com.murilo.planeja.dominio.categoria.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, UUID> {

    // select exists ( select 1 from categoria where nome = ?1 )
    boolean existsByNome(String nome);

}
