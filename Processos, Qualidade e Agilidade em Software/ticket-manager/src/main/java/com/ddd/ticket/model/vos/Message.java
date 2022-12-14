package com.ddd.ticket.model.vos;

import java.time.LocalDateTime;

import com.ddd.ticket.model.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Message {

	private User from;
	private String body;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime dataRegistro;

	public Message(User from, String body) throws Exception {
		if (from == null)
			throw new Exception("O usuario da mensagem nao pode estar vazio");
		
		if (body == null || body.isBlank())
			throw new Exception("A mensagem nao pode estar vazia");

		if (body.length() > 1000)
			throw new Exception("A mensagem nao pode ter mais do que 1000 caracteres");

		this.from = from;
		this.body = body;
		this.dataRegistro = LocalDateTime.now();
	}

	public User getFrom() {
		return from;
	}

	public String getBody() {
		return body;
	}
	
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

}
