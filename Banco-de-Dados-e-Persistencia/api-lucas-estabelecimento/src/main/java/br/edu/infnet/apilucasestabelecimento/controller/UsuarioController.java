package br.edu.infnet.apilucasestabelecimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apilucasestabelecimento.model.domain.Usuario;
import br.edu.infnet.apilucasestabelecimento.model.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@PostMapping(value = "/validar")
	public Usuario validar(@RequestParam String login, @RequestParam String senha) {
		return service.validar(login, senha);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}
	
}
