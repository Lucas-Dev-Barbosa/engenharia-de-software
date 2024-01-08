package br.com.bookstock.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_estoque")
@SuppressWarnings("serial")
public class Estoque extends AbstractEntity {

	@Column(columnDefinition = "int default 0")
	@Min(value = 0, message = "O valor do estoque não pode ser negativo.")
	private Integer emEstoque = 0;
	
	@Column(columnDefinition = "int default 0")
	@Min(value = 0, message = "O valor de vendidos não pode ser negativo.")
	private Integer vendidos = 0;
	
	@OneToOne(mappedBy = "estoque")
	private Livro idLivro;

}
