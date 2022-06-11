package br.edu.infnet.apilucasestabelecimento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apilucasestabelecimento.model.domain.Funcionario;
import br.edu.infnet.apilucasestabelecimento.model.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;

	@GetMapping(value = "/{idEstabelecimento}/listar")
	public List<Funcionario> obterLista(@PathVariable Integer idEstabelecimento) {
		return service.obterLista(idEstabelecimento);
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Funcionario funcionario) {
		service.incluir(funcionario);
	}
	
}
