package com.ddd.ticket.model.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ddd.ticket.model.domain.Ticket;
import com.ddd.ticket.model.domain.User;
import com.ddd.ticket.model.repository.TicketRepository;
import com.ddd.ticket.model.vos.Cargo;
import com.ddd.ticket.model.vos.Email;
import com.ddd.ticket.model.vos.Message;
import com.ddd.ticket.model.vos.Name;
import com.ddd.ticket.model.vos.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;

	public void processaFechamentoTicket(Integer id) throws Exception {
		Ticket ticket = repository.getTicket(id);

		if (ticket == null)
			throw new Exception("Ticket nao encontrado em nossa base");
		
		if (ticket.getAssignedAgent().getCargo().equals(Cargo.GERENTE))
			throw new Exception("Este ticket foi escalado para um gerente. Somente um gerente pode fecha-lo");

		List<Message> messages = ticket.getMessages();
		Message message = messages.get(messages.size() - 1);

		if (!message.getFrom().getCargo().equals(Cargo.CLIENTE) && ticket.getStatus().equals(Status.EM_ANDAMENTO)) {
			LocalDateTime dataRegistro = message.getDataRegistro();
			LocalDateTime dataRegistro4Dias = dataRegistro.plusDays(4);

			if (LocalDateTime.now().compareTo(dataRegistro4Dias) > 0) {
				Message mensagemFechamento = new Message(
						new User(new Name("Sistema", "Ticket"), new Email("sistema@api.com"), Cargo.SISTEMA),
						"Fechamento automatico de ticket");
				
				ticket.fecharTicket(mensagemFechamento);
				
				repository.salvaTicket(ticket);
			}

		}
	}

}
