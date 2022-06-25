package br.edu.infnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.model.domain.Endereco;
import br.edu.infnet.model.service.EnderecoService;

@Controller
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping("/enderecos")
	public String telaLista(Model model) {
		List<Endereco> enderecos = service.obterLista();
		model.addAttribute("lista", enderecos);
		
		return "/endereco/lista";
	}
	
	@GetMapping("/endereco")
	public String telaCadastro() {
		return "/endereco/cadastro";
	}
	
	@PostMapping("/endereco")
	public String buscar(Model model, @RequestParam String cep) {
		Endereco e = service.obterPorCep(cep);
		
		model.addAttribute("endereco", e);
		return "/endereco/cadastro";
	}
	
	@PostMapping("/endereco/incluir")
	public String incluir(Endereco endereco) {
		service.incluir(endereco);
		return "redirect:/enderecos";
	}
	
	@GetMapping("/endereco/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		service.excluir(id);
		return "redirect:/enderecos";
	}

}
