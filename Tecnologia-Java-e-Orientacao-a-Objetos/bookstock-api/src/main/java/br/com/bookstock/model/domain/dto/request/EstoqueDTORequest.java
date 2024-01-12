package br.com.bookstock.model.domain.dto.request;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstoqueDTORequest {

	@Min(value = 0, message = "O valor do estoque não pode ser negativo.")
	private Integer emEstoque = 0;
	
	@Min(value = 0, message = "O valor de vendidos não pode ser negativo.")
	private Integer vendidos = 0;
	
}
