package br.com.bookstock.model.domain.dto.request;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.number.NumberStyleFormatter;

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
	private List<Long> autores;

	@NotBlank(message = "Digite o ISBN.")
	private String isbn;

	@NotNull(message = "Digite a identificacao da editora.")
	private Long editora;

	private byte[] fotoCapa;

	@NotNull(message = "Informe o preço.")
	private BigDecimal preco;

	@NotNull(message = "Informe a data de publicação.")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataPublicacao;

	@Min(value = 1, message = "O número de páginas tem que ser maior do que zero.")
	@NotNull(message = "Digite o número de páginas")
	private Integer numeroPaginas;
	
	private String tipo;
	
	private EstoqueDTORequest estoque = new EstoqueDTORequest();

	public String getPreco() {
		if (this.preco != null)
			return getNumberFormat().format(this.preco);

		return null;
	}

	public void setPreco(String preco) throws ParseException {
		if (preco != null && !preco.isEmpty())
			this.preco = (BigDecimal) getNumberFormat().parse(preco);
	}

	@JsonIgnore
	private NumberFormat getNumberFormat() {
		return new NumberStyleFormatter("###,###.##").getNumberFormat(LocaleContextHolder.getLocale());
	}
	
	public void setTitulo(String titulo) throws ParseException {
		if (titulo != null && !titulo.isEmpty())
			this.titulo = titulo.trim();
	}
	
	public void setSinopse(String sinopse) throws ParseException {
		if (sinopse != null && !sinopse.isEmpty())
			this.sinopse = sinopse.trim();
	}
	
	public void setIsbn(String isbn) throws ParseException {
		if (isbn!= null && !isbn.isEmpty())
			this.isbn = isbn.trim();
	}

}
