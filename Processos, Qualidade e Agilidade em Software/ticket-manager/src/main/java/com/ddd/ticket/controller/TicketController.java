package com.ddd.ticket.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.ddd.ticket.model.domain.Ticket;
import com.ddd.ticket.model.domain.User;
import com.ddd.ticket.model.dto.TicketDto;
import com.ddd.ticket.model.repository.TicketRepository;
import com.ddd.ticket.model.service.TicketService;
import com.ddd.ticket.model.vos.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TicketController {

	@Autowired
	private TicketRepository repository;
	
	@Autowired
	private TicketService service;

	@GetMapping
	public List<TicketDto> listaTickets() {
		return repository.listaTickets().stream().map(ticket -> ticket.getDto()).collect(Collectors.toList());
	}
	
	@GetMapping("/{idTicket}")
	public TicketDto obtemTicket(@PathVariable Integer idTicket) {
		return repository.getTicket(idTicket).getDto();
	}

	@PostMapping("/abre-ticket")
	public TicketDto abreTicket(@RequestBody Ticket ticket) throws Exception {

		repository.salvaTicket(ticket);

		return ticket.getDto();
	}
	
	@PostMapping("/{idTicket}/adiciona-mensagem")
	public TicketDto adicionaMensagem(@PathVariable Integer idTicket, @RequestBody Message message) throws Exception {
		Ticket ticket = repository.getTicket(idTicket);
		ticket.adicionarMensagem(message);
		
		repository.salvaTicket(ticket);

		return ticket.getDto();
	}
	
	@PostMapping("/{idTicket}/vincula-ticket")
	public TicketDto vinculaTicket(@PathVariable Integer idTicket, @RequestBody User agent) throws Exception {
		Ticket ticket = repository.getTicket(idTicket);
		ticket.vincularTicket(agent);
		
		repository.salvaTicket(ticket);

		return ticket.getDto();
	}
	
	@PostMapping("/{idTicket}/escala-ticket")
	public TicketDto escalaTicket(@PathVariable Integer idTicket, @RequestBody User agent) throws Exception {
		Ticket ticket = repository.getTicket(idTicket);
		ticket.escalarTicket(agent);
		
		repository.salvaTicket(ticket);

		return ticket.getDto();
	}
	
	@PostMapping("/{idTicket}/fecha-ticket")
	public TicketDto fechaTicket(@PathVariable Integer idTicket, @RequestBody Message message) throws Exception {
		Ticket ticket = repository.getTicket(idTicket);
		ticket.fecharTicket(message);
		
		repository.salvaTicket(ticket);

		return ticket.getDto();
	}
	
	@GetMapping("/{idTicket}/reabre-ticket")
	public TicketDto reabreTicket(@PathVariable Integer idTicket) throws Exception {
		Ticket ticket = repository.getTicket(idTicket);
		ticket.reabrirTicket();
		
		repository.salvaTicket(ticket);

		return ticket.getDto();
	}
	
	@GetMapping("/{idTicket}/processa-fechamento")
	public void processaFechamentoTicket(@PathVariable Integer idTicket) throws Exception {
		service.processaFechamentoTicket(idTicket);
	}

}
