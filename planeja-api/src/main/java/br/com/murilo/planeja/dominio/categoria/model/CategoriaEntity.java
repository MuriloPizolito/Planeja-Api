package br.com.murilo.planeja.dominio.categoria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column
    private String nome;

    @Column
    private Boolean ativo; // = true
    // primeira maneira, já inicia como true direto aqui, ou cria o prePersist

    @PrePersist
    public void prePersist(){
        setAtivo(true);
    } // segunda maneira de fazer

}
