package br.com.bookstock.model.domain.dto.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class LivroDTOResponse extends AbstractDTOResponse {

	private String titulo;

	private String sinopse;

	private List<Long> autoresId;

	private String isbn;

	private Long editoraId;

	private byte[] fotoCapa;

	private String preco;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataPublicacao;

	private Integer numeroPaginas;
	
	private String tipo;
	
	private Long estoqueId;
	
}
