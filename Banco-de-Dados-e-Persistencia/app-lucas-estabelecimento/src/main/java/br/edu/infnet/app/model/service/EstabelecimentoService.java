package br.edu.infnet.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.app.client.EstabelecimentoClient;
import br.edu.infnet.app.model.domain.Estabelecimento;
import br.edu.infnet.app.model.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoClient client;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EstabelecimentoRepository repository;

	public List<Estabelecimento> listaEstabelecimentos() {
		return client.obterLista();
	}
	
	public Estabelecimento obterEstabelecimentoPorFuncionario(Integer idFuncionario) {
		return client.obterEstabelecimentoPorFuncionario(idFuncionario);
	}

	public void incluir(Estabelecimento estabelecimento) {
		estabelecimento.setSenha(usuarioService.getPasswordEncoded(estabelecimento.getSenha()));
		repository.save(estabelecimento);
	}

	public void excluir(Integer idEstabelecimento) {
		repository.deleteById(idEstabelecimento);
	}

	
}
