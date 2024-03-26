package br.edu.infnet.lucas.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.lucas.model.domain.Usuario;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import br.edu.infnet.lucas.service.IUsuarioService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private IUsuarioService usuarioService;
	
    @GetMapping("/login")
    public String showFormLogin(Model model, @ModelAttribute("message") String message) throws PedidoException {
    	model.addAttribute("usuario", new Usuario());
    	model.addAttribute("message", message);
    	
        return "login";
    }
    
    @PostMapping("/efetuarLogin")
    public String efetuarLogin(Usuario usuario, Model model, RedirectAttributes redirectAttributes, HttpSession session){
        Optional<Usuario> usuarioOpt = usuarioService.getUsuarioByEmail(usuario.getEmail());
        
        if(usuarioOpt.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "Usuário não cadastrado");
            return "redirect:/auth/login";
        }else{
            Usuario usuarioBanco = usuarioOpt.get();
            if(usuarioBanco.getPassword().equals(usuario.getPassword())){
                session.setAttribute("usuarioLogado", usuarioBanco);
                return "redirect:/";
            }else {
                redirectAttributes.addFlashAttribute("message", "Senha Inválida");
                redirectAttributes.addFlashAttribute("login-sucesso", false);
                return "redirect:/auth/login";
            }
        }

    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("usuarioLogado", null);
        return  "redirect:/login";
    }

}
