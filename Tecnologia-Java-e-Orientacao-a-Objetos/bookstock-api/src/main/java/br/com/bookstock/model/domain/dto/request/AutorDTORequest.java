package br.com.bookstock.model.domain.dto.request;

import java.text.ParseException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorDTORequest {

	@NotBlank(message = "Digite o nome do autor.")
	private String nome;
	
	@Min(value = 1, message = "A idade do autor tem que ser maior do que zero.")
	@NotNull(message = "Digite a idade do autor")
	private Integer idade;
	
	@NotBlank(message = "Digite o endereco.")
	private String endereco;
	
	public void setNome(String nome) throws ParseException {
		if (nome != null && !nome.isEmpty())
			this.nome = nome.trim();
	}
	
	public void setEndereco(String endereco) throws ParseException {
		if (endereco != null && !endereco.isEmpty())
			this.endereco = endereco.trim();
	}

}
