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
import br.com.bookstock.model.domain.Editora;
import br.com.bookstock.model.domain.dto.request.EditoraDTORequest;
import br.com.bookstock.model.domain.dto.response.EditoraDTOResponse;
import br.com.bookstock.model.domain.service.EditoraBkService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/editora")
@Tag(name = "Editora Endpoint")
public class EditoraController extends AbstractController<EditoraDTORequest, EditoraDTOResponse, Editora> {

	private final EditoraBkService<Editora> editoraBkService;
	
	public EditoraController(EditoraBkService<Editora> editoraBkService) {
		this.editoraBkService = editoraBkService;
	}

	@GetMapping
	@Tag(name = "listarEditoras", description = "Retorna uma lista com todas as editoras cadastradas no sistema")
	public List<EditoraDTOResponse> listarEditoras() {
		return editoraBkService.getListaEditora()
				.stream()
				.map(editora -> convertEntityToDto(editora, EditoraDTOResponse.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	@Tag(name = "buscarEditoraPorId", description = "Retorna uma editora pelo seu id")
	public EditoraDTOResponse buscarEditoraPorId(@PathVariable Long id) throws BookStockException {
		return convertEntityToDto(editoraBkService.obterEditoraPorId(id), EditoraDTOResponse.class);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Tag(name = "cadastrarEditora", description = "Realiza o cadastramento de uma editora na base")
	public EditoraDTOResponse cadastrarEditora(@Valid @RequestBody EditoraDTORequest editoraRequest) throws BookStockException {
		Editora editora = convertDtoToEntity(editoraRequest, Editora.class);
		EditoraDTOResponse newEditora = convertEntityToDto(editoraBkService.salvarEditora(editora), EditoraDTOResponse.class);
		return newEditora;
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Tag(name = "editarEditora", description = "Realiza alteração de alguma informação de uma editora na base")
	public void editarEditora(@PathVariable Long id, @Valid @RequestBody EditoraDTORequest editora) throws BookStockException {
		editoraBkService.editarEditora(id, convertDtoToEntity(editora, Editora.class));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Tag(name = "excluirEditora", description = "Realiza a exclusão de uma editora na base")
	public void excluirEditora(@PathVariable Long id) throws BookStockException {
		editoraBkService.excluirEditora(id);
	}
	
}
