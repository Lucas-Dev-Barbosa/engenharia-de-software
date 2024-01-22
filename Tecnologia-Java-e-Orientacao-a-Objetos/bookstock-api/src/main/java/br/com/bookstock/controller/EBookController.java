package br.com.bookstock.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import br.com.bookstock.model.domain.EBook;
import br.com.bookstock.model.domain.dto.request.EBookDTORequest;
import br.com.bookstock.model.domain.dto.response.EBookDTOResponse;
import br.com.bookstock.model.domain.service.EBookService;
import br.com.bookstock.model.domain.service.TituloService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ebook")
@Tag(name = "Ebook Endpoint")
public class EBookController extends AbstractController<EBookDTORequest, EBookDTOResponse, EBook>{

	private final TituloService<EBook> service;
	
	public EBookController(EBookService service) {
		this.service = service;
	}

	@GetMapping
	@Tag(name = "listarLivros", description = "Retorna uma lista com todos os ebooks no estoque")
	public List<EBookDTOResponse> listarLivros() {
		return service.getListaTitulos()
				.stream()
				.map(EBook -> convertEntityToDto(EBook, EBookDTOResponse.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	@Tag(name = "buscarLivroPorId", description = "Retorna um livro pelo seu id")
	public EBookDTOResponse buscarLivroPorId(@PathVariable Long id) throws BookStockException {
		return convertEntityToDto(service.obterTituloPorId(id), EBookDTOResponse.class);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Tag(name = "cadastrarLivro", description = "Realiza o cadastramento de um livro no estoque. Será criado um novo registro na base de estoque")
	public EBookDTOResponse cadastrarLivro(@Valid @RequestBody EBookDTORequest livroRequest) throws BookStockException {
		EBook livro = convertDtoToEntity(livroRequest, EBook.class);
		EBookDTOResponse newLivro = convertEntityToDto(service.salvarTitulo(livro), EBookDTOResponse.class);
		return newLivro;
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Tag(name = "editarLivro", description = "Realiza alteração de alguma informação de um livro no estoque")
	public void editarLivro(@PathVariable Long id, @Valid @RequestBody EBookDTORequest livro) throws BookStockException {
		service.editarTitulo(id, convertDtoToEntity(livro, EBook.class));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Tag(name = "excluirTitulo", description = "Realiza a exclusão de um livro no estoque")
	public void excluirTitulo(@PathVariable Long id) throws BookStockException {
		service.excluirTitulo(id);
	}

}
