package br.com.murilo.planeja.dominio.lancamento;

import br.com.murilo.planeja.dominio.lancamento.model.LancamentoEntity;
import br.com.murilo.planeja.dominio.lancamento.model.TipoLancamento;
import org.springframework.data.jpa.domain.Specification;

import java.time.YearMonth;
import java.util.UUID;

public class LancamentoSpecs {

    public LancamentoSpecs() {
    }

    public static Specification<LancamentoEntity> tipoEqual(TipoLancamento tipo) {
        return (root, query, cb) -> {
//          LancamentoEntity.tipo = :tipo;

            return cb.equal(root.get("tipo"), tipo);
        };
    }

    public static Specification<LancamentoEntity> categoriaEqual(UUID categoriaId) {
        return (root, query, cb) -> {
            return cb.equal(root.get("categoria").get("id"), categoriaId);
        };
    }

    public static Specification<LancamentoEntity> mesEqual(YearMonth mes) {
        return (root, query, cb) -> {
            var inicioMes = mes.atDay(1);
            var fimMes = mes.atEndOfMonth();

            return cb.between(root.get("data"), inicioMes, fimMes);
        };
    }
}
