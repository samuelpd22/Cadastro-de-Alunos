package com.cadastroAlunosapi.exceptions;

public class UsuarioJaExisteException extends RuntimeException {

    public UsuarioJaExisteException(String message) {
        super(message);
    }


}
