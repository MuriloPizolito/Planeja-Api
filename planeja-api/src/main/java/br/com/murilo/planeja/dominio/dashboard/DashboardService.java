package br.com.murilo.planeja.dominio.dashboard;

import br.com.murilo.planeja.dominio.dashboard.dto.Dashboard;
import br.com.murilo.planeja.dominio.dashboard.dto.DespesaCategoriaResumo;
import br.com.murilo.planeja.dominio.dashboard.dto.ResumoFinanceiro;
import br.com.murilo.planeja.dominio.lancamento.LancamentoRepository;
import br.com.murilo.planeja.dominio.lancamento.model.TipoLancamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Dashboard obterDashboardMesAtual() {
        YearMonth mesAtual = YearMonth.now();
        LocalDate primeiroDiaDoMes = mesAtual.atDay(1);
        LocalDate ultimoDia = mesAtual.atEndOfMonth();

        BigDecimal receitas = lancamentoRepository.somaPorTipoNoPeriodo(TipoLancamento.RECEITA, primeiroDiaDoMes, ultimoDia);
        BigDecimal despesas = lancamentoRepository.somaPorTipoNoPeriodo(TipoLancamento.DESPESA, primeiroDiaDoMes, ultimoDia);
        BigDecimal saldo = receitas.subtract(despesas);

        ResumoFinanceiro resumoFinanceiro = new ResumoFinanceiro(receitas, despesas, saldo);

        List<DespesaCategoriaResumo> despesasPorCategoria = lancamentoRepository.somaPorCategoriaNoPeriodo(TipoLancamento.DESPESA, primeiroDiaDoMes, ultimoDia)
                .stream()
                .map(resultado -> new DespesaCategoriaResumo((String) resultado[0], (BigDecimal) resultado[1])
                ).toList();

        return new Dashboard(mesAtual.toString(), resumoFinanceiro, despesasPorCategoria);
    }

}
