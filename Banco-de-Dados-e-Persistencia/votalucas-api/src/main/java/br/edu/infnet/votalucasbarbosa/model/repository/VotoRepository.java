package br.edu.infnet.votalucasbarbosa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.votalucasbarbosa.model.domain.Voto;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Integer>{

	@Query("from Voto v where v.candidato.id = :idCandidato")
	List<Voto> findByCandidato(Integer idCandidato);

	@Query("from Voto v where v.eleicao.id = :idEleicao")
	List<Voto> findByEleicao(Integer idEleicao);

}
