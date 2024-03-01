package br.edu.infnet.lucas.model.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.edu.infnet.lucas.file.json.deserializer.ProdutoDeserializer;
import lombok.Data;

@JsonDeserialize(using = ProdutoDeserializer.class)
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.CHAR)
public abstract class Produto {
    
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
    private String nome;
    private double valor;
    private int codigo;
    private char tipo;
    
    @ManyToOne
    @JoinTable(
            name="PRODUTO_PEDIDO",
            joinColumns=
                @JoinColumn(name="produtoId", referencedColumnName="id"),
            inverseJoinColumns=
                @JoinColumn(name="pedidoId", referencedColumnName="id")
        )
    private Pedido pedido;

    public abstract String getDescricaoProduto();

}
