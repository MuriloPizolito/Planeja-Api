package br.com.murilo.planeja.dominio.usuario.dto;

public record AuthResponse(
        String token,
        String tipo,
        long expiraEm,
        String nome
) {
}
