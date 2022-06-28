package br.edu.infnet.votalucasbarbosa.exceptionHandler;

import java.util.Date;
import java.util.List;

public class ErrorMessage {
	
	private Date timestamp;
	private int status;
	private String error;
	private List<String> message;
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}

}
