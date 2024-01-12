package br.com.bookstock.model.domain.dto.response;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.number.NumberStyleFormatter;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LivroDTOResponse extends AbstractDTOResponse {

	private String titulo;

	private String sinopse;

	private List<AutorDTOResponse> autores;

	private String isbn;

	private EditoraDTOResponse editora;

	private byte[] fotoCapa;

	private BigDecimal preco;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataPublicacao;

	private Integer numeroPaginas;
	
	private String tipo;
	
	private EstoqueDTOResponse estoque;

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
	
}
