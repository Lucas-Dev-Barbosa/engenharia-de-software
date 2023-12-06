package br.edu.infnet.lucas.controller.exception.handler;

import br.edu.infnet.lucas.model.domain.exception.NegocioException;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PedidoControllerExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, Object> pedidoException(NegocioException ex, HttpServletRequest request) {
        return getBodyMessage(ex.getStatus(), ex.getMessage(), request.getRequestURI());
    }

    private Map<String, Object> getBodyMessage(int status, String error, String path) {
        Map<String, Object> bodyMessage = new HashMap<>();
        bodyMessage.put("timestamp", new Date());
        bodyMessage.put("status", status);
        bodyMessage.put("error", error);
        bodyMessage.put("path", path);

        return bodyMessage;
    }

}
