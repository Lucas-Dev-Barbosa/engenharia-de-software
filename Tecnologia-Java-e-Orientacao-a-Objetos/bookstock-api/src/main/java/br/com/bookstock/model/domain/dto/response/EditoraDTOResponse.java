package br.com.bookstock.model.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditoraDTOResponse extends AbstractDTOResponse {

	private String razaoSocial;
	
	private String endereco;
	
	private String cnpj;
	
}
