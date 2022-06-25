package br.edu.infnet.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.clients.LocalidadeClient;
import br.edu.infnet.model.domain.Estado;
import br.edu.infnet.model.domain.Municipio;

@Service
public class LocalidadeService {
	
	@Autowired
	private LocalidadeClient client;

	public List<Estado> obterListaEstados() {
		return client.obterLista();
	}

	public List<Municipio> obterMunicipiosPorUf(String id) {
		return client.obterMunicipiosPorUf(id);
	}

}
