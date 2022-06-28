package br.edu.infnet.votalucasbarbosa.model.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votalucasbarbosa.clients.votaclient.VotosEndPoint;
import br.edu.infnet.votalucasbarbosa.model.domain.Voto;

@Service
public class VotoService {

	@Autowired
	private VotosEndPoint client;

	public void incluir(Voto voto) {
		client.incluir(voto);
	}

	public List<Voto> obterLista() {
		return client.obterLista();
	}

	public void excluir(Integer id) {
		client.excluir(id);
	}

}
