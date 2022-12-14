package com.ddd.ticket.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ddd.ticket.model.dto.TicketDto;
import com.ddd.ticket.model.vos.Cargo;
import com.ddd.ticket.model.vos.Message;
import com.ddd.ticket.model.vos.Priority;
import com.ddd.ticket.model.vos.Status;

public class Ticket {

	private Integer id;
	private String titulo;

	private Status status;
	private Priority priority;
	
	private LocalDateTime sla;
	private LocalDateTime dataFechamento;
	
	private User customer;
	private User assignedAgent;
	
	private List<Product> products;
	private List<Message> messages;

	public Ticket(String titulo, User customer, List<Product> products, String message, Priority priority)
			throws Exception {
		if (titulo == null || titulo.isBlank())
			throw new Exception("O titulo nao pode estar vazio");

		if (customer == null)
			throw new Exception("Preencha o customer");

		if (products == null || products.size() == 0)
			throw new Exception("Preencha os produtos do ticket");

		this.id = new Random().nextInt(1000000000);
		this.titulo = "[" + id + "] " + titulo;
		this.customer = customer;
		this.products = products;
		this.priority = priority == null ? Priority.LOW : priority;
		this.status = Status.ABERTO;

		adicionarMensagem(new Message(customer, message));
	}

	public void adicionarMensagem(Message message) throws Exception {
		String emailMessage = message.getFrom().getEmail().getEmailAddress();

		String emailCustomer = this.customer.getEmail().getEmailAddress();

		if ((this.assignedAgent == null && !emailMessage.equals(emailCustomer)))
			throw new Exception("E necessario vincular o ticket a um agente");

		if (this.messages == null)
			this.messages = new ArrayList<>();

		this.messages.add(message);
	}

	public void vincularTicket(User agent) throws Exception {
		if (this.assignedAgent == null) {
			atualizarStatus(Status.EM_ANDAMENTO);
		}

		this.assignedAgent = agent;
	}

	public void escalarTicket(User agent) throws Exception {
		calculaSla(this.priority);

		if(!agent.getCargo().equals(Cargo.GERENTE))
			throw new Exception("E necessario escalar o ticket para um gerente");
		
		this.assignedAgent = agent;
	}
	
	public void fecharTicket(Message message) throws Exception {
		adicionarMensagem(message);
		atualizarStatus(Status.FECHADO);
		
		this.dataFechamento = LocalDateTime.now();
	}
	
	public void reabrirTicket() throws Exception {
		if(this.dataFechamento.plusDays(7).compareTo(LocalDateTime.now()) < 0)
			throw new Exception("O ticket passou do prazo para reabertura");
		
		adicionarMensagem(new Message(this.customer, "Ticket reaberto pelo cliente"));
		atualizarStatus(Status.EM_ANDAMENTO);
	}

	public boolean isSlaEstourado() {
		return this.sla != null && LocalDateTime.now().compareTo(this.sla) > 0;
	}
	
	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Status getStatus() {
		return status;
	}

	public Priority getPriority() {
		return priority;
	}

	public LocalDateTime getSla() {
		return sla;
	}

	public User getCustomer() {
		return customer;
	}

	public User getAssignedAgent() {
		return assignedAgent;
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<Message> getMessages() {
		return messages;
	}
	
	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}
	
	public TicketDto getDto() {
		TicketDto dto = new TicketDto();
		
		dto.setId(this.id);
		dto.setTitulo(this.titulo);
		dto.setStatus(this.status);
		dto.setPriority(this.priority);
		dto.setSla(this.sla);
		dto.setDataFechamento(this.dataFechamento);
		dto.setCustomer(this.customer);
		dto.setAssignedAgent(this.assignedAgent);
		dto.setProducts(this.products);
		dto.setMessages(this.messages);
		
		return dto;
	}

	private void calculaSla(Priority priority) {
		long fatorDeCalculo = 0;
		switch (priority) {
			case LOW:
				fatorDeCalculo = 30L;
				break;
			case MEDIUM:
				fatorDeCalculo = 20L;
				break;
			case HIGH:
				fatorDeCalculo = 10L;
				break;
			default:
				break;
		}
		
		if(isSlaEstourado())
			fatorDeCalculo = (33 * fatorDeCalculo) / 100;
		
		setSla(fatorDeCalculo);
	}

	private void setSla(Long minunts) {
		this.sla = LocalDateTime.now().plusMinutes(minunts);
	}

	private void atualizarStatus(Status status) throws Exception {
		if (status == null)
			throw new Exception("E necessario inserir o status do ticket");

		if (status.equals(Status.ABERTO))
			throw new Exception("O status nao pode ser igual a " + Status.ABERTO);

		if (this.status.equals(Status.ABERTO) && status.equals(Status.EM_ANDAMENTO))
			calculaSla(this.priority);
		
		this.status = status;
	}

}
