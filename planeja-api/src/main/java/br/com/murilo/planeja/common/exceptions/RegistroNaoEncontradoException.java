package br.com.murilo.planeja.common.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException{
    public RegistroNaoEncontradoException() {
        super("Registro não encontrado.");
    }
}
