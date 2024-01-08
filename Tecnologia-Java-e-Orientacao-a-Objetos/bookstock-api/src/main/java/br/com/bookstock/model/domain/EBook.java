package br.com.bookstock.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "ebook")
@SuppressWarnings("serial")
public class EBook extends Livro {

	@NotNull(message = "Digite o tipo da capa.")
	private Long tamanhoArquivo;
	
	@NotBlank(message = "Digite as dimensoes do livro.")
	private String formato;
	
	@NotBlank(message = "Digite o tipo de papel.")
	private String tipoFonte;
	
}
