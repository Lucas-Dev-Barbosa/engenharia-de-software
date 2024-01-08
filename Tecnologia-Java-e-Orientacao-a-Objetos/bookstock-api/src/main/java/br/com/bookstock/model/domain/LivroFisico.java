package br.com.bookstock.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "fisico")
@SuppressWarnings("serial")
public class LivroFisico extends Livro {

	@NotBlank(message = "Digite o tipo da capa.")
	private String tipoCapa;
	
	@NotBlank(message = "Digite as dimensoes do livro.")
	private String dimensoes;
	
	@NotBlank(message = "Digite o tipo de papel.")
	private String tipoPapel;
	
}
