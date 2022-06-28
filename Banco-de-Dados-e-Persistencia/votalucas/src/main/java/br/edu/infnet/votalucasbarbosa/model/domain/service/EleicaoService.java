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
public class EleicaoService {
	
	@Autowired
	private EleicoesEndPoint client;
	
	@Autowired
	private VotosEndPoint clientVotos;
	
	@Autowired
	private CandidatosEndPoint clientCandidatos;
	
	public void incluir(Eleicao eleicao) {
		client.incluir(eleicao);
	}
	
	public List<Eleicao> obterLista(){
		List<Eleicao> listEleicoes = client.obterLista();
		
		List<Voto> listVotos;
		List<Candidato> listCandidatos;
		for(Eleicao eleicao : listEleicoes) {
			listVotos = clientVotos.listarVotosPorEleicao(eleicao.getId());
			eleicao.setVotos(listVotos);
			
			listCandidatos = clientCandidatos.listaCandidatosPorEleicao(eleicao.getId());
			eleicao.setCandidatos(listCandidatos);
		}
		
		return listEleicoes;
	}
	
	public Eleicao obterPorId(Integer id) {
		Eleicao eleicao = client.obterEleicaoPorId(id);
		
		List<Voto> listVotos = clientVotos.listarVotosPorEleicao(eleicao.getId());
		eleicao.setVotos(listVotos);
		
		List<Candidato> listCandidatos = clientCandidatos.listaCandidatosPorEleicao(eleicao.getId());
		eleicao.setCandidatos(listCandidatos);
		
		return eleicao;
	}

	public void excluir(Integer id) {
		client.excluir(id);
	}
	
}
