package br.edu.infnet.lucas.model.domain.exception;

public class PedidoException extends Exception {

    private int status = 401;

    public PedidoException(String message) {
        super(message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
