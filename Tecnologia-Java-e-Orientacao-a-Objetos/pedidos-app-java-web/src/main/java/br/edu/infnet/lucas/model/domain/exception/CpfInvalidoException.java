package br.edu.infnet.lucas.model.domain.exception;

public class CpfInvalidoException extends NegocioException {

    public CpfInvalidoException() {
        super("Cpf invalido");
    }

    public CpfInvalidoException(String message) {
        super(message);
    }
}
