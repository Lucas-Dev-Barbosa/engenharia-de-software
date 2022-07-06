package br.edu.infnet.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.app.client.EstabelecimentoClient;
import br.edu.infnet.app.client.FuncionarioClient;
import br.edu.infnet.app.model.domain.Estabelecimento;
import br.edu.infnet.app.model.domain.Funcionario;
import br.edu.infnet.app.model.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioClient client;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EstabelecimentoClient estabelecimentoClient;
	
	@Autowired
	private FuncionarioRepository repository;

	public List<Funcionario> listaFuncionarios() {
		List<Funcionario> listaFuncionarios = client.obterLista();
		
		Estabelecimento estabelecimento;
		for(Funcionario funcionario : listaFuncionarios) {
			estabelecimento = estabelecimentoClient.obterEstabelecimentoPorFuncionario(funcionario.getId());
			funcionario.setEstabelecimento(estabelecimento);
		}
		
		return listaFuncionarios;
	}

	public void incluir(Funcionario funcionario) {
		funcionario.setSenha(usuarioService.getPasswordEncoded(funcionario.getSenha()));
		repository.save(funcionario);
	}

	public void excluir(Integer idFuncionario) {
		repository.deleteById(idFuncionario);
	}
	
}
