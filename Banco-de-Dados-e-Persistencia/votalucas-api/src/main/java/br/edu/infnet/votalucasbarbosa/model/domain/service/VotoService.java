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
	
	public List<Voto> obterLista(){
		return (List<Voto>) votoRepository.findAll();
	}
	
	public Voto incluir(Voto voto) {
		return votoRepository.save(voto);
	}

	public void excluir(Integer id) {
		votoRepository.deleteById(id);
	}

	public List<Voto> listarVotosPorCandidato(Integer idCandidato) {
		return votoRepository.findByCandidato(idCandidato);
	}

	public List<Voto> listarVotosPorEleicao(Integer idEleicao) {
		return votoRepository.findByEleicao(idEleicao);
	}

	public List<Voto> listarVotosPorEleitor(Integer idEleitor) {
		return votoRepository.findByEleitor(idEleitor);
	}
	
}
