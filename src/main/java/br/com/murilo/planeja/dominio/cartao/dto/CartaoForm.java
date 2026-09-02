package br.com.murilo.planeja.dominio.cartao.dto;

import br.com.murilo.planeja.dominio.cartao.model.BandeiraCartao;

//Data acess object
public record CartaoForm(String nome, BandeiraCartao bandeira) {
}
