package br.edu.infnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.model.domain.Endereco;
import br.edu.infnet.model.domain.Role;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.service.RoleService;
import br.edu.infnet.model.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value = "/usuario")
	public String usuario(Model model) {
		System.out.println("Cadastro de usuário!!");
		
		model.addAttribute("roles", roleService.obterLista());
		
		return "/usuario/cadastro";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluirUsuario(Usuario usuario, Endereco endereco, @RequestParam Integer acesso) {
		usuario.setRoles(List.of(new Role(acesso)));
		usuario.setEndereco(endereco);
		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}
	
}
