package br.edu.infnet.apilucasestabelecimento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apilucasestabelecimento.model.domain.Estabelecimento;
import br.edu.infnet.apilucasestabelecimento.model.service.EstabelecimentoService;

@RestController
@RequestMapping("api/estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService service;
	
	@GetMapping(value = "/listar")
	public List<Estabelecimento> obterLista() {
		return service.obterLista();
	}
	
	@GetMapping("/{idFuncionario}")
	public Estabelecimento obterEstabelecimentoPorFuncionario(@PathVariable Integer idFuncionario) {
		Estabelecimento estabelecimento = service.getEstabelecimentoPorFuncionario(idFuncionario);
		
		return estabelecimento;
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Estabelecimento estabelecimento) {
		service.incluir(estabelecimento);
	}
	
}
