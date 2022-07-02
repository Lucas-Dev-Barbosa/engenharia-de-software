package br.edu.infnet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.model.domain.Usuario;

@SessionAttributes("user")
@Controller
public class AppController {

	@GetMapping(value = "/")
	public String telaIndex() {
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "/login";
	}
	
//	@PostMapping(value = "/login")
//	public String login(Model model, @RequestParam String login, @RequestParam String senha) {
//		Usuario usuario = usuarioService.autenticar(login, senha);
//		
//		if(usuario != null) {
//			//Quando usamos o redirect: os valores do Model se perdem, mas como o atributo user já existe como de sessão, o valor não se perde
//			model.addAttribute("user", usuario);
//			return "redirect:/";
//		}
//		
//		return "redirect:/login";
//	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @AuthenticationPrincipal Usuario usuario) {
		return "redirect:/login";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/negado")
	public String negado() {
		return "negado";
	}
	
}
