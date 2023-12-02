package br.edu.infnet.lucas.model.domain.exception;

public class EmailInvalidoException extends NegocioException {

    public EmailInvalidoException() {
        super("E-mail invalido");
    }

    public EmailInvalidoException(String message) {
        super(message);
    }
}
