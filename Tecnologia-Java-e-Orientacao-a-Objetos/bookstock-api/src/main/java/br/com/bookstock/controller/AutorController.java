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
import br.com.bookstock.model.domain.Autor;
import br.com.bookstock.model.domain.dto.request.AutorDTORequest;
import br.com.bookstock.model.domain.dto.response.AutorDTOResponse;
import br.com.bookstock.model.domain.service.AutorBkService;
import br.com.bookstock.model.domain.service.AutorService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/autor")
@Tag(name = "Autor Endpoint")
public class AutorController extends AbstractController<AutorDTORequest, AutorDTOResponse, Autor> {
	
	private final AutorBkService<Autor> autorBkService;

	public AutorController(AutorService autorService) {
		this.autorBkService = autorService;
	}
	
	@GetMapping
	@Tag(name = "listarAutores", description = "Retorna uma lista com todos os autores cadastrados no sistema")
	public List<AutorDTOResponse> listarLivros() {
		return autorBkService.getListaAutor()
				.stream()
				.map(autor -> convertEntityToDto(autor, AutorDTOResponse.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	@Tag(name = "buscarAutorPorId", description = "Retorna um autor pelo seu id")
	public AutorDTOResponse buscarAutorPorId(@PathVariable Long id) throws BookStockException {
		return convertEntityToDto(autorBkService.obterAutorPorId(id), AutorDTOResponse.class);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Tag(name = "cadastrarAutor", description = "Realiza o cadastramento de um autor na base")
	public AutorDTOResponse cadastrarAutor(@Valid @RequestBody AutorDTORequest autorRequest) throws BookStockException {
		Autor autor = convertDtoToEntity(autorRequest, Autor.class);
		AutorDTOResponse newAutor = convertEntityToDto(autorBkService.salvarAutor(autor), AutorDTOResponse.class);
		return newAutor;
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Tag(name = "editarAutor", description = "Realiza alteração de alguma informação de um autor na base")
	public void editarAutor(@PathVariable Long id, @Valid @RequestBody AutorDTORequest autor) throws BookStockException {
		autorBkService.editarAutor(id, convertDtoToEntity(autor, Autor.class));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Tag(name = "excluirAutor", description = "Realiza a exclusão de um autor na base")
	public void excluirAutor(@PathVariable Long id) throws BookStockException {
		autorBkService.excluirAutor(id);
	}

}
