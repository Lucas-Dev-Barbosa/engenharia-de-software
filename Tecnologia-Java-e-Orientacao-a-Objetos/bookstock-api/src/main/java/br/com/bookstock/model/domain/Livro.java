package br.com.bookstock.model.domain;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.number.NumberStyleFormatter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@Table(name = "tb_livro", uniqueConstraints = @UniqueConstraint(columnNames = { "isbn" }))
@SuppressWarnings("serial")
public abstract class Livro extends AbstractEntity {

	private String titulo;

	@Column(columnDefinition = "TEXT")
	private String sinopse;

	@ManyToMany
	@JoinTable(name = "tb_livro_autor", joinColumns = {@JoinColumn(name = "livroId")}, inverseJoinColumns = {@JoinColumn(name = "autorId")})
	private List<Autor> autores;

	@Column(length = 20)
	private String isbn;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEditora")
	private Editora editora;

	@Column(columnDefinition = "LONGBLOB")
	private byte[] fotoCapa;

	@Column(columnDefinition = "DECIMAL(19,2)")
	private BigDecimal preco;

	@NotNull(message = "Informe a data de publicação.")
	private Date dataPublicacao;

	private Integer numeroPaginas;
	
	@Column(insertable=false, updatable=false)
    private String tipo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estoqueId", referencedColumnName = "id")
	private Estoque estoque;

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
