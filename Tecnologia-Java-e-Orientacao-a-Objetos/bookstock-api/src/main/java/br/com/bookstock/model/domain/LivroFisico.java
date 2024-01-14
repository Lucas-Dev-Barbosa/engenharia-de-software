package br.com.bookstock.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "fisico")
@SuppressWarnings("serial")
public class LivroFisico extends Livro {

	private String tipoCapa;
	
	private String dimensoes;
	
	private String tipoPapel;
	
}
