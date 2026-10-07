package br.com.murilo.planeja.dominio.categoria.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CategoriaForm(
        @NotBlank(message = "Campo obrigatório.")
        String nome) {
}
