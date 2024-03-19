package br.edu.infnet.lucas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.lucas.model.domain.Usuario;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;

@Controller
@RequestMapping("/auth")
public class AuthController {

	
    @GetMapping("/login")
    public String showFormLogin(Model model) throws PedidoException {
    	model.addAttribute("usuario", new Usuario());
        return "login";
    }

}
