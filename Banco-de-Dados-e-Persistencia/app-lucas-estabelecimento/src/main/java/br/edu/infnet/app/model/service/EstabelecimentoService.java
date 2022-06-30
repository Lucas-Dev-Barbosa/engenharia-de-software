package br.edu.infnet.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.app.client.EstabelecimentoClient;
import br.edu.infnet.app.client.UsuarioClient;
import br.edu.infnet.app.model.domain.Estabelecimento;

@Service
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoClient client;
	
	@Autowired
	private UsuarioClient usuarioCliente;

	public List<Estabelecimento> listaEstabelecimentos() {
		return client.obterLista();
	}
	
	public Estabelecimento obterEstabelecimentoPorFuncionario(Integer idFuncionario) {
		return client.obterEstabelecimentoPorFuncionario(idFuncionario);
	}

	public void incluir(Estabelecimento estabelecimento) {
		client.incluir(estabelecimento);
	}

	public void excluir(Integer idEstabelecimento) {
		usuarioCliente.excluir(idEstabelecimento);
	}

	
	
}
