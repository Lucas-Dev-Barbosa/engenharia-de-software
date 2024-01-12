package br.com.bookstock.model.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstoqueDTOResponse extends AbstractDTOResponse {

	private Integer emEstoque;
	
	private Integer vendidos;
	
}
