package br.com.bookstock.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "ebook")
@SuppressWarnings("serial")
public class EBook extends Livro {

	private Long tamanhoArquivo;
	
	private String formato;
	
	private String tipoFonte;
	
}
