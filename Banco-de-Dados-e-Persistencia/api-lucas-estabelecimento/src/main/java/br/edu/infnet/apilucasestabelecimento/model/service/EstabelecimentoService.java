package br.edu.infnet.apilucasestabelecimento.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apilucasestabelecimento.model.domain.Estabelecimento;
import br.edu.infnet.apilucasestabelecimento.model.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository repository;

	public void incluir(Estabelecimento estabelecimento) {
		repository.save(estabelecimento);
	}

	public List<Estabelecimento> obterLista() {
		return (List<Estabelecimento>) repository.findAll();
	}

	public void excluir(Integer idEstabelecimento) {
		repository.deleteById(idEstabelecimento);
	}

	public Estabelecimento getEstabelecimentoPorFuncionario(Integer idFuncionario) {
		return repository.findEstabelecimentoByFuncionario(idFuncionario);
	}

}
