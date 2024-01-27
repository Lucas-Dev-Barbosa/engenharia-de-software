package br.com.bookstock.model.domain;

import java.text.ParseException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_editora")
@SuppressWarnings("serial")
public class Editora extends AbstractEntity {

	private String razaoSocial;
	
	private String endereco;
	
	private String cnpj;
	
	@OneToMany(mappedBy = "editora")
	private List<Livro> livros;
	
	public void setRazaoSocial(String razaoSocial) throws ParseException {
		if (razaoSocial != null && !razaoSocial.isEmpty())
			this.razaoSocial = razaoSocial.trim();
	}
	
	public void setEndereco(String endereco) throws ParseException {
		if (endereco != null && !endereco.isEmpty())
			this.endereco = endereco.trim();
	}
	
	public void setCnpj(String cnpj) throws ParseException {
		if (cnpj != null && !cnpj.isEmpty())
			this.cnpj = cnpj.trim();
	}
	
}
