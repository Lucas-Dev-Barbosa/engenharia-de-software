package br.edu.infnet.apilucasestabelecimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apilucasestabelecimento.model.domain.Estabelecimento;
import br.edu.infnet.apilucasestabelecimento.model.service.EstabelecimentoService;

@RestController
@RequestMapping("api/estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService service;

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Estabelecimento estabelecimento) {
		service.incluir(estabelecimento);
	}
	
}
