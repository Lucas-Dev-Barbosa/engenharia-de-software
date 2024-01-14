package br.com.bookstock.model.domain.dto.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class LivroDTORequest {

	@NotBlank(message = "Digite o título.")
	private String titulo;

	@NotBlank(message = "Digite a sinopse do livro.")
	private String sinopse;

	@NotNull(message = "O livro precisa de pelo menos um autor")
	private List<Long> autoresId;

	@NotBlank(message = "Digite o ISBN.")
	private String isbn;

	@NotNull(message = "Digite a identificacao da editora.")
	private Long editoraId;

	private byte[] fotoCapa;

	@NotNull(message = "Informe o preço.")
	private String preco;

	@NotNull(message = "Informe a data de publicação.")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataPublicacao;

	@Min(value = 1, message = "O número de páginas tem que ser maior do que zero.")
	@NotNull(message = "Digite o número de páginas")
	private Integer numeroPaginas;
	
	private String tipo;

}
