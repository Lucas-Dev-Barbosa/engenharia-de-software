package br.edu.infnet.votalucasbarbosa.model.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votalucasbarbosa.model.domain.Voto;
import br.edu.infnet.votalucasbarbosa.model.repository.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;
	
	public void incluir(Voto voto) {
		votoRepository.save(voto);
	}
	
	public List<Voto> obterLista(){
		return (List<Voto>) votoRepository.findAll();
	}

	public void excluir(Integer id) {
		votoRepository.deleteById(id);
	}
	
}
