package br.com.bookstock.model.domain.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditoraDTORequest {

	@NotBlank(message = "Digite a razao social da editora.")
	private String razaoSocial;
	
	@NotBlank(message = "Digite o endereco da editora.")
	private String endereco;
	
	@NotBlank(message = "Digite o cnpj da editora.")
	private String cnpj;
	
}
