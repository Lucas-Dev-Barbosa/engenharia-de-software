package br.edu.infnet.votalucasbarbosa.model.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votalucasbarbosa.clients.votaclient.CandidatosEndPoint;
import br.edu.infnet.votalucasbarbosa.clients.votaclient.EleicoesEndPoint;
import br.edu.infnet.votalucasbarbosa.clients.votaclient.VotosEndPoint;
import br.edu.infnet.votalucasbarbosa.model.domain.Candidato;
import br.edu.infnet.votalucasbarbosa.model.domain.Eleicao;
import br.edu.infnet.votalucasbarbosa.model.domain.Voto;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatosEndPoint client;
	
	@Autowired
	private EleicoesEndPoint clientEleicoes;
	
	@Autowired
	private VotosEndPoint clientVotos;
	
	public void incluir(Candidato candidato) {
		client.incluir(candidato);
	}
	
	public List<Candidato> obterLista(){
		List<Candidato> listCandidatos = client.obterLista();
		
		Eleicao eleicao;
		List<Voto> listVotos;
		for(Candidato candidato : listCandidatos) {
			eleicao = clientEleicoes.obterEleicaoPorCandidato(candidato.getId());
			candidato.setEleicao(eleicao);
			
			listVotos = clientVotos.listarVotosPorCandidato(candidato.getId());
			candidato.setVotos(listVotos);
		}
		
		return listCandidatos;
	}

	public void excluir(Integer id) {
		client.excluir(id);
	}
	
}
