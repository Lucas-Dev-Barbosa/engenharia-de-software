package br.com.bookstock.model.domain;

import java.text.ParseException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_editora")
@SuppressWarnings("serial")
public class Editora extends AbstractEntity {

	@NotBlank(message = "Digite a razao social da editora.")
	private String razaoSocial;
	
	@NotBlank(message = "Digite o endereco da editora.")
	private String endereco;
	
	@NotBlank(message = "Digite o cnpj da editora.")
	private String cnpj;
	
	@OneToMany
	@JoinColumn(name = "idEditora")
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
