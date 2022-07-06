package br.edu.infnet.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.app.model.domain.Estabelecimento;
import br.edu.infnet.app.model.domain.Funcionario;
import br.edu.infnet.app.model.domain.Role;
import br.edu.infnet.app.model.service.EstabelecimentoService;
import br.edu.infnet.app.model.service.FuncionarioService;
import br.edu.infnet.app.model.service.RoleService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private RoleService roleService;

	@GetMapping
	public String lista(Model model) {
		List<Funcionario> listaFuncionario = service.listaFuncionarios();
		model.addAttribute("listaFuncionario", listaFuncionario);
		
		List<Estabelecimento> listaEstabelecimento = estabelecimentoService.listaEstabelecimentos();
		model.addAttribute("listaEstabelecimento", listaEstabelecimento);
		
		model.addAttribute("roles", roleService.obterLista());
		
		
		return "funcionario/lista";
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(Funcionario funcionario, @RequestParam Integer acesso) {
		funcionario.setRoles(List.of(new Role(acesso)));
		service.incluir(funcionario);
		
		return "redirect:/funcionarios";
	}
	
	@GetMapping(value = "/{idFuncionario}/preExcluir")
	public String preExcluir(RedirectAttributes attr, @PathVariable Integer idFuncionario) {
		attr.addFlashAttribute("idFuncionarioExcluir", idFuncionario);
		return "redirect:/funcionarios";
	}
	
	@GetMapping(value = "/{idFuncionario}/excluir")
	public String excluir(@PathVariable Integer idFuncionario) {
		service.excluir(idFuncionario);
		return "redirect:/funcionarios";
	}
	
}
