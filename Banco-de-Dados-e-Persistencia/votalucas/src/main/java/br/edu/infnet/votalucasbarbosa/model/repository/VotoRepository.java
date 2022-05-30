package br.edu.infnet.votalucasbarbosa.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.votalucasbarbosa.model.domain.Voto;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Integer>{

}
