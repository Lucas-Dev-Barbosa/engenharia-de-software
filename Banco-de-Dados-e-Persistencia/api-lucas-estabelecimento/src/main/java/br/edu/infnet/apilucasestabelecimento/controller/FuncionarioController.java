package br.edu.infnet.apilucasestabelecimento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value = "/listar")
	public List<Funcionario> obterLista(Model model) {
		return service.obterLista();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Funcionario funcionario) {
		service.incluir(funcionario);
	}
	
}
