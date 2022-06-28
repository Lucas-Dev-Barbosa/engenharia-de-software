package br.edu.infnet.votalucasbarbosa.exceptionhandler;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> messages = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		Map<String, Object> body = getBody(status.value(), status.getReasonPhrase(), messages);

		return new ResponseEntity<Object>(body, headers, status);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> constraintViolationException(SQLIntegrityConstraintViolationException ex) throws IOException {
		
		Map<String, Object> body = getBody(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), List.of("Violação de integridade"));
		
		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
		
	}
	
	private Map<String, Object> getBody(int status, String error, List<String> message){
		Map<String, Object> body = new LinkedHashMap<>();
		
		body.put("timestamp", new Date());
		body.put("status", status);
		body.put("error", error);
		body.put("message", message);
		
		return body;
	}

}
