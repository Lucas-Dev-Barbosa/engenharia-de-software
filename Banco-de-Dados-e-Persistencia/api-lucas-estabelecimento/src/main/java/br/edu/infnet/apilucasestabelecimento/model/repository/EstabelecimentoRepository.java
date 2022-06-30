package br.edu.infnet.apilucasestabelecimento.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.apilucasestabelecimento.model.domain.Estabelecimento;

public interface EstabelecimentoRepository extends CrudRepository<Estabelecimento, Integer>{

	@Query("select f.estabelecimento from Funcionario f where f.id = :idFuncionario")
	Estabelecimento findEstabelecimentoByFuncionario(Integer idFuncionario);

}
