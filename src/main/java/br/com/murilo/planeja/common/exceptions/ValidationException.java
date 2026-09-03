package br.com.murilo.planeja.common.exceptions;

import br.com.murilo.planeja.common.validation.CampoInvalido;

import java.util.List;

public class ValidationException extends RuntimeException{

    private final List<CampoInvalido> camposInvalidos;

    public ValidationException(List<CampoInvalido> camposInvalidos){
        super("Erro de validação.");
        this.camposInvalidos = camposInvalidos;
    }

    public List<CampoInvalido> getCampoInvalidos() {
        return camposInvalidos;
    }
}
