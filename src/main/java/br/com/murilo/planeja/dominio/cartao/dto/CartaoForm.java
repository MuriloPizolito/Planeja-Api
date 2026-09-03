package br.com.murilo.planeja.dominio.cartao.dto;

import br.com.murilo.planeja.dominio.cartao.model.BandeiraCartao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Data acess object
public record CartaoForm(
        @NotBlank(message = "Campo obrigatório.")
        String nome,

        @NotNull(message = "Campo obrigatório.")
        BandeiraCartao bandeira) {
}
