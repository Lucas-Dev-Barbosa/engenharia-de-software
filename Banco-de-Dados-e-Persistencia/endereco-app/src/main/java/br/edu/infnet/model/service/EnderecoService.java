package br.edu.infnet.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.clients.CepClient;
import br.edu.infnet.clients.EnderecoClient;
import br.edu.infnet.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoClient client;
	
	@Autowired
	private CepClient cepClient;
	
	public List<Endereco> obterLista() {
		return client.obterLista();
	}
	
	public Endereco obterPorCep(String cep) {
		Endereco endereco = cepClient.obterPorCep(cep);
		
		if(endereco == null) {
			return new Endereco(cep);
		} else {
			return endereco;
		}
	}
	
	public void incluir(Endereco endereco) {
		client.incluir(endereco);
	}	
	
	public void excluir(Integer id) {
		client.excluir(id);
	}
	
}
