package br.com.bookstock.model.domain.dto.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EBookDTOResponse extends LivroDTOResponse {

	@NotNull(message = "Digite o tipo da capa.")
	private Long tamanhoArquivo;
	
	@NotBlank(message = "Digite as dimensoes do livro.")
	private String formato;
	
	@NotBlank(message = "Digite o tipo de papel.")
	private String tipoFonte;
	
}
