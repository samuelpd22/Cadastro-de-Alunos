package com.cadastroAlunosapi.exceptions;

public class UsuarioJaExisteException extends RuntimeException {

    public UsuarioJaExisteException(String nome) {
        super("Usuário já cadastrado no banco de dados.");
    }
}
