package br.com.bookstock.model.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LivroFisicoDTOResponse extends LivroDTOResponse {

	private String tipoCapa;
	
	private String dimensoes;
	
	private String tipoPapel;
	
}
