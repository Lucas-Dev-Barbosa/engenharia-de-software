package com.ddd.ticket.model.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ddd.ticket.model.domain.Ticket;

import org.springframework.stereotype.Repository;

@Repository
public class TicketRepository {

	private Map<Integer, Ticket> tickets;

	public TicketRepository() {
		if (tickets == null)
			tickets = new HashMap<>();
	}

	public void salvaTicket(Ticket ticket) {
		tickets.put(ticket.getId(), ticket);
	}

	public void deletaTicket(Integer id) {
		tickets.remove(id);
	}

	public Ticket getTicket(Integer id) {
		return tickets.get(id);
	}

	public List<Ticket> listaTickets() {
		return tickets.values().stream().map(ticket -> ticket).collect(Collectors.toList());
	}

}
