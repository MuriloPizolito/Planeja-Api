package br.com.murilo.planeja.dominio.cartao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "cartao")
@Getter
@Setter
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @PrePersist // executa antes de persistir os dados no banco
    public void prePersist() {
        setDataCadastro(LocalDateTime.now());
    }

}
