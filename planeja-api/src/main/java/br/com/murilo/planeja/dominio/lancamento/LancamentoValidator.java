package br.com.murilo.planeja.dominio.lancamento;

import br.com.murilo.planeja.common.validation.ValidationResult;
import br.com.murilo.planeja.dominio.cartao.model.CartaoEntity;
import br.com.murilo.planeja.dominio.categoria.model.CategoriaEntity;
import br.com.murilo.planeja.dominio.lancamento.dto.LancamentoForm;
import org.springframework.stereotype.Component;

@Component
public class LancamentoValidator {

    public ValidationResult validar(LancamentoForm form, CategoriaEntity categoria, CartaoEntity cartao){

        return ValidationResult.novo();
    }

}
