package br.edu.infnet.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.app.client.EstabelecimentoClient;
import br.edu.infnet.app.client.FuncionarioClient;
import br.edu.infnet.app.client.UsuarioClient;
import br.edu.infnet.app.model.domain.Estabelecimento;
import br.edu.infnet.app.model.domain.Funcionario;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioClient client;
	
	@Autowired
	private UsuarioClient usuarioCliente;
	
	@Autowired
	private EstabelecimentoClient estabelecimentoClient;

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
		client.incluir(funcionario);
	}

	public void excluir(Integer idEstabelecimento) {
		usuarioCliente.excluir(idEstabelecimento);
	}
	
}
