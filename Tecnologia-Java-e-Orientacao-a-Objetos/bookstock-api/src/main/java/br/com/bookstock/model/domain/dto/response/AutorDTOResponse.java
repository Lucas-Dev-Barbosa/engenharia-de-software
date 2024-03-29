package br.com.bookstock.model.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AutorDTOResponse extends AbstractDTOResponse {

	private String nome;
	
	private Integer idade;
	
	private String endereco;
	
}
