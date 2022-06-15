package br.edu.infnet.votalucasbarbosa.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleicao;

@Repository
public interface EleicaoRepository extends CrudRepository<Eleicao, Integer>{

	@Query("select c.eleicao from Candidato c where c.id = :idCandidato")
	Eleicao findEleicaoByIdCandidato(Integer idCandidato);

}
