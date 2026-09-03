package br.com.murilo.planeja.dominio.cartao;

import br.com.murilo.planeja.common.validation.CampoInvalido;
import br.com.murilo.planeja.common.validation.ValidationResult;
import br.com.murilo.planeja.dominio.cartao.dto.CartaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoValidator {

    @Autowired
    private CartaoRepository repository;

    public ValidationResult validar(CartaoForm form) {
        var result = ValidationResult.novo();

        if (repository.findByNome(form.nome()).isPresent()) {
            result.add(new CampoInvalido("nome", "Já cadastrado."));
        }

        return result;
    }

}
