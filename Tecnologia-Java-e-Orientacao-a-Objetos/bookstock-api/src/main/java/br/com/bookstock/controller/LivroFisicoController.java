package br.com.bookstock.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.LivroFisico;
import br.com.bookstock.model.domain.dto.request.LivroFisicoDTORequest;
import br.com.bookstock.model.domain.dto.response.LivroFisicoDTOResponse;
import br.com.bookstock.model.domain.service.LivroFisicoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/livrofisico")
@Tag(name = "Livro Endpoint")
public class LivroFisicoController extends AbstractController<LivroFisicoDTORequest, LivroFisicoDTOResponse, LivroFisico>{

	@Autowired
	private LivroFisicoService service;

	@GetMapping
	@Tag(name = "listarLivros", description = "Retorna uma lista com todos os livros no estoque")
	public List<LivroFisicoDTOResponse> listarLivros() {
		return service.getListaLivros()
				.stream()
				.map(livroFisico -> convertEntityToDto(livroFisico, LivroFisicoDTOResponse.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	@Tag(name = "buscarLivroPorId", description = "Retorna um livro pelo seu id")
	public LivroFisicoDTOResponse buscarLivroPorId(@PathVariable Long id) throws BookStockException {
		return convertEntityToDto(service.obterLivroPorId(id), LivroFisicoDTOResponse.class);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Tag(name = "cadastrarLivro", description = "Realiza o cadastramento de um livro no estoque. Será criado um novo registro na base de estoque")
	public LivroFisicoDTOResponse cadastrarLivro(@Valid @RequestBody LivroFisicoDTORequest livroRequest) throws BookStockException {
		LivroFisico livro = convertDtoToEntity(livroRequest, LivroFisico.class);
		LivroFisicoDTOResponse newLivro = convertEntityToDto(service.salvarLivro(livro), LivroFisicoDTOResponse.class);
		return newLivro;
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	@Tag(name = "editarLivro", description = "Realiza alteração de alguma informação de um livro no estoque")
	public void editarLivro(@Valid @RequestBody LivroFisicoDTORequest livro) throws BookStockException {
		service.editarLivro(convertDtoToEntity(livro, LivroFisico.class));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Tag(name = "excluirTitulo", description = "Realiza a exclusão de um livro no estoque")
	public void excluirTitulo(@PathVariable Long id) throws BookStockException {
		service.excluirTitulo(id);
	}

}
