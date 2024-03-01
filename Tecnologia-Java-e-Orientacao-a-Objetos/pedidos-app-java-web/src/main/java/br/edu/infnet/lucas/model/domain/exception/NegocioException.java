package br.edu.infnet.lucas.model.domain.exception;

public abstract class NegocioException extends Exception {

    private int status = 400;

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException() {
        super();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
