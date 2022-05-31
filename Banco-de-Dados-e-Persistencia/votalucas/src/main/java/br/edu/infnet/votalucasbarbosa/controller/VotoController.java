package br.edu.infnet.votalucasbarbosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleicao;
import br.edu.infnet.votalucasbarbosa.model.domain.Eleitor;
import br.edu.infnet.votalucasbarbosa.model.domain.Voto;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleicaoService;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleitorService;
import br.edu.infnet.votalucasbarbosa.model.domain.service.VotoService;

@Controller
public class VotoController {
	@Autowired
	private VotoService votoService;

	@Autowired
	private EleitorService eleitorService;
	
	@Autowired
	private EleicaoService eleicaoService;
	
	@GetMapping(value = "/votos")
	public String lista(Model model) {
		List<Voto> listaVoto = votoService.obterLista();
		model.addAttribute("lista", listaVoto);
		
		List<Eleicao> listaEleicao = eleicaoService.obterLista();
		model.addAttribute("eleicoes", listaEleicao);
		
		return "voto/lista";
	}

	@PostMapping(value = "/voto")
	public String cadastro(Voto voto, Model model) {
		List<Eleitor> listaEleitor = eleitorService.obterLista();
		model.addAttribute("eleitores", listaEleitor);
		
		Eleicao eleicao = eleicaoService.obterPorId(voto.getEleicao().getId());
		model.addAttribute("eleicao", eleicao);
		
		return "voto/cadastro";
	}
	
	@PostMapping(value = "voto/incluir")
	public String incluir(Voto voto) {
		votoService.incluir(voto);
		
		return "redirect:/votos";
	}
	
	@GetMapping(value = "/voto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		votoService.excluir(id);
		
		return "redirect:/votos";
	}
	
}
