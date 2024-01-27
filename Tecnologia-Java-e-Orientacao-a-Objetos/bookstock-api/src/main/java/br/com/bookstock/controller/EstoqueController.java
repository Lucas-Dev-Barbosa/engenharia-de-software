package br.com.bookstock.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.Estoque;
import br.com.bookstock.model.domain.dto.request.EstoqueDTORequest;
import br.com.bookstock.model.domain.dto.response.EstoqueDTOResponse;
import br.com.bookstock.model.domain.service.EstoqueBkService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/estoque")
@Tag(name = "Estoque Endpoint")
public class EstoqueController extends AbstractController<EstoqueDTORequest, EstoqueDTOResponse, Estoque> {
	
	private final EstoqueBkService<Estoque> estoqueBkService;

	public EstoqueController(EstoqueBkService<Estoque> estoqueBkService) {
		this.estoqueBkService = estoqueBkService;
	}
	
	@GetMapping
	@Tag(name = "listarEstoque", description = "Retorna uma lista do estoque de livros cadastrado no sistema")
	public List<EstoqueDTOResponse> listarEstoque() {
		return estoqueBkService.getListaEstoque()
				.stream()
				.map(estoque -> convertEntityToDto(estoque, EstoqueDTOResponse.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	@Tag(name = "buscarEstoquePorId", description = "Retorna as informações do estoque de um determinado livro pelo ID do estoque")
	public EstoqueDTOResponse buscarEstoquePorId(@PathVariable Long id) throws BookStockException {
		return convertEntityToDto(estoqueBkService.obterEstoquePorId(id), EstoqueDTOResponse.class);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Tag(name = "editarEstoque", description = "Realiza alteração de alguma informação do estoque de um determinado livro")
	public void editarEstoque(@PathVariable Long id, @Valid @RequestBody EstoqueDTORequest estoque) throws BookStockException {
		estoqueBkService.editarEstoque(id, convertDtoToEntity(estoque, Estoque.class));
	}

}
