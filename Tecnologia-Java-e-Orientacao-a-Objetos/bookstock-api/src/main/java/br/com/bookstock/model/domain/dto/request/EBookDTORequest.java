package br.com.bookstock.model.domain.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EBookDTORequest extends LivroDTORequest {

	@NotNull(message = "Digite o tamanho do arquivo.")
	private Long tamanhoArquivo;
	
	@NotBlank(message = "Digite o formato do arquivo.")
	private String formato;
	
	@NotBlank(message = "Digite o tipo da fonte do arquivo.")
	private String tipoFonte;
	
}
