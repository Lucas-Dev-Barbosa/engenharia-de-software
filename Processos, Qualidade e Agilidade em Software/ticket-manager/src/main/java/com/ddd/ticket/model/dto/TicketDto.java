package com.ddd.ticket.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ddd.ticket.model.domain.Product;
import com.ddd.ticket.model.domain.User;
import com.ddd.ticket.model.vos.Message;
import com.ddd.ticket.model.vos.Priority;
import com.ddd.ticket.model.vos.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TicketDto {
	
	private Integer id;
	private String titulo;

	private Status status;
	private Priority priority;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime sla;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime dataFechamento;
	
	private User customer;
	private User assignedAgent;
	
	private List<Product> products;
	private List<Message> messages;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public LocalDateTime getSla() {
		return sla;
	}
	public void setSla(LocalDateTime sla) {
		this.sla = sla;
	}
	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public User getAssignedAgent() {
		return assignedAgent;
	}
	public void setAssignedAgent(User assignedAgent) {
		this.assignedAgent = assignedAgent;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
