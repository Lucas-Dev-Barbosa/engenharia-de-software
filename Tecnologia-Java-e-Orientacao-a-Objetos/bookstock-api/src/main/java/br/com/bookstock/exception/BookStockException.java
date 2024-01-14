package br.com.bookstock.exception;

import org.springframework.http.HttpStatus;

public class BookStockException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status = HttpStatus.BAD_REQUEST;
	
	public BookStockException(String message) {
		super(message);
	}

	public BookStockException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
}
