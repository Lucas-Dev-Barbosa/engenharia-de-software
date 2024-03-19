package br.edu.infnet.lucas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.lucas.model.domain.Usuario;
import br.edu.infnet.lucas.service.IRoleService;
import br.edu.infnet.lucas.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
    private IUsuarioService usuarioService;
	
	@Autowired
    private IRoleService roleService;

    @GetMapping("/lista")
    public ModelAndView listaUsuarios(ModelAndView modelAndView) {
    	modelAndView.addObject("usuarios", usuarioService.listaUsuario());
    	modelAndView.setViewName("usuarios/list-usuarios");
        return modelAndView;
    }
    
    @GetMapping("/new")
    public String usuario(Model model) {
    	model.addAttribute("roles", roleService.listaRole());
    	return "usuarios/usuario";
    }
    
    @PostMapping("/salva")
    public String insertUsuarios(Usuario usuario) {
        usuarioService.insertUsuario(usuario);
        return "redirect:/usuarios/lista";
    }

    @GetMapping("/usuario/{idUsuario}")
    public String getUsuarioById(@PathVariable(name = "idUsuario") Long id, Model model) {
    	model.addAttribute("usuario", usuarioService.getUsuarioById(id));
    	return "usuarios/usuario"; 
    }

    @GetMapping("/{idUsuario}/delete")
    public String deleteUsuarioById(@PathVariable(name = "idUsuario") Long id) {
        usuarioService.deleteUsuarioById(id);
        return "redirect:/usuarios/lista";
    }

    @PutMapping
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

}
