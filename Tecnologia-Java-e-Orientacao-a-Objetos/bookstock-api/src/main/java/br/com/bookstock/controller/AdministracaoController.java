package br.com.bookstock.controller;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bookstock.model.domain.service.AdministracaoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/admin")
@Tag(name = "Admin Endpoint")
public class AdministracaoController {

	private final AdministracaoService administracaoService;

	public AdministracaoController(AdministracaoService administracaoService) {
		this.administracaoService = administracaoService;
	}
	
	@GetMapping(value = "/download-relatorio", produces = "text/csv")
	@Tag(name = "downloadRelatorio", description = "Realiza o download da visao atual dos dados do sistema BookStock em arquivo CSV")
	public Resource downloadRelatorio() throws IOException {
		FileInputStream fileInputStream = administracaoService.downloadRelatorio();
		InputStreamResource streamResource = new InputStreamResource(fileInputStream);
		
		return streamResource;
	}
	
}
