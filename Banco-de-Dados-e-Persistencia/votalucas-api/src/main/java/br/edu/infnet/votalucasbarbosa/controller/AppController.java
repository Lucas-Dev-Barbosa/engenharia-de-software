package br.edu.infnet.votalucasbarbosa.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.votalucasbarbosa.info.InfoApi;

@RestController
@RequestMapping("/api/info")
public class AppController {
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public InfoApi index() {
		return new InfoApi();
	}
	
}
