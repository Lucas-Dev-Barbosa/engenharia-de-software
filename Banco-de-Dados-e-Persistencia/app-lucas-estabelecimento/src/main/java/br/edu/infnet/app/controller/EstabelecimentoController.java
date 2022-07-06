package br.edu.infnet.app.controller;

import java.util.List;
import java.util.Optional;

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
import br.edu.infnet.app.model.domain.Role;
import br.edu.infnet.app.model.service.EstabelecimentoService;
import br.edu.infnet.app.model.service.RoleService;

@Controller
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService service;
	
	@Autowired
	private RoleService roleService;

	@GetMapping
	public String lista(Model model, @RequestParam("modo") Optional<String> modo) {
		if(!modo.isEmpty()) {
			if(modo.get().equals("listaCrua") || modo.get().equals("listaPorFuncionario")) {
				List<Estabelecimento> listaEstabelecimentos = service.listaEstabelecimentos();
				model.addAttribute(modo.get(), listaEstabelecimentos);
			}
		}
		model.addAttribute("roles", roleService.obterLista());
		
		return "estabelecimento/lista";
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(Estabelecimento estabelecimento, @RequestParam Integer acesso) {
		estabelecimento.setRoles(List.of(new Role(acesso)));
		service.incluir(estabelecimento);
		
		return "redirect:/estabelecimentos?modo=listaCrua";
	}
	
	@GetMapping(value = "/{idEstabelecimento}/preExcluir")
	public String preExcluir(RedirectAttributes attr, @PathVariable Integer idEstabelecimento) {
		attr.addFlashAttribute("idEstabelecimentoExcluir", idEstabelecimento);
		return "redirect:/estabelecimentos?modo=listaCrua";
	}
	
	@GetMapping(value = "/{idEstabelecimento}/excluir")
	public String excluir(@PathVariable Integer idEstabelecimento) {
		service.excluir(idEstabelecimento);
		return "redirect:/estabelecimentos?modo=listaCrua";
	}
	
}
