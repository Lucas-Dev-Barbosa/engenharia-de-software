package br.edu.infnet.votalucasbarbosa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleitor;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleitorService;

@RestController
@RequestMapping("/api/eleitores")
public class EleitorController {
	@Autowired
	private EleitorService eleitorService;
	
	@GetMapping
	public List<Eleitor> lista() {
		List<Eleitor> listaEleitor = eleitorService.obterLista();
		return listaEleitor;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Eleitor incluir(@Valid @RequestBody Eleitor eleitor) {
		return eleitorService.incluir(eleitor);
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Integer id) {
		eleitorService.excluir(id);
	}
	
}
