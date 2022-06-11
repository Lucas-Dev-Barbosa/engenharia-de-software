package br.edu.infnet.apilucasestabelecimento.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apilucasestabelecimento.model.domain.Funcionario;
import br.edu.infnet.apilucasestabelecimento.model.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;

	public List<Funcionario> obterLista(Integer idEstabelecimento) {
		return repository.obterLista(idEstabelecimento);
	}
	
	public void incluir(Funcionario funcionario) {
		repository.save(funcionario);
	}
	
}
