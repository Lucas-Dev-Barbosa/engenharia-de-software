package br.com.bookstock.model.domain.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroFisicoDTORequest extends LivroDTORequest {

	@NotBlank(message = "Digite o tipo da capa.")
	private String tipoCapa;
	
	@NotBlank(message = "Digite as dimensoes do livro.")
	private String dimensoes;
	
	@NotBlank(message = "Digite o tipo de papel.")
	private String tipoPapel;
	
}
