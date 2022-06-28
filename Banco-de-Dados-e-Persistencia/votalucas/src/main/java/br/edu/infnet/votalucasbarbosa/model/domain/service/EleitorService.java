package br.edu.infnet.votalucasbarbosa.model.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votalucasbarbosa.clients.votaclient.EleitoresEndPoint;
import br.edu.infnet.votalucasbarbosa.clients.votaclient.VotosEndPoint;
import br.edu.infnet.votalucasbarbosa.model.domain.Eleitor;
import br.edu.infnet.votalucasbarbosa.model.domain.Voto;

@Service
public class EleitorService {
	
	@Autowired
	private EleitoresEndPoint client;
	
	@Autowired
	private VotosEndPoint clientVotos;
	
	public void incluir(Eleitor eleitor) {
		client.incluir(eleitor);
	}
	
	public List<Eleitor> obterLista(){
		List<Eleitor> listEleitores = client.lista();
		
		List<Voto> listVotos;
		for(Eleitor eleitor : listEleitores) {
			listVotos = clientVotos.listarVotosPorEleitor(eleitor.getId());
			eleitor.setVotos(listVotos);
		}
		
		return listEleitores;
	}

	public void excluir(Integer id) {
		client.excluir(id);
	}
	
}
