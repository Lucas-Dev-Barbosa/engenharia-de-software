package br.edu.infnet.apilucasestabelecimento.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.apilucasestabelecimento.model.domain.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{

	@Query("from Funcionario f where f.estabelecimento.id = :idEstabelecimento")
	public List<Funcionario> obterLista(Integer idEstabelecimento);
	
}
