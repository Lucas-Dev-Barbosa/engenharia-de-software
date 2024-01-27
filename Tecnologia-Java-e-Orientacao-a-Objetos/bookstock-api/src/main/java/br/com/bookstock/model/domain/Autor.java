package br.com.bookstock.model.domain;

import java.text.ParseException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_autor")
@SuppressWarnings("serial")
public class Autor extends AbstractEntity {

	private String nome;
	
	private Integer idade;
	
	private String endereco;
	
	@ManyToMany(mappedBy = "autores")
	private List<Livro> livros;
	
	public void setNome(String nome) throws ParseException {
		if (nome != null && !nome.isEmpty())
			this.nome = nome.trim();
	}
	
	public void setEndereco(String endereco) throws ParseException {
		if (endereco != null && !endereco.isEmpty())
			this.endereco = endereco.trim();
	}

}
