package br.com.murilo.planeja.dominio.dashboard.dto;

import java.math.BigDecimal;

public record ResumoFinanceiro(
        BigDecimal receitas,
        BigDecimal despesas,
        BigDecimal saldo
) {
}
