package br.edu.infnet.lucas.model.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Date data;
    private boolean web;

    @OneToOne
    private Solicitante solicitante;
    
    @JoinTable(
            name="PRODUTO_PEDIDO",
            joinColumns=
                @JoinColumn(name="pedidoId", referencedColumnName="id"),
            inverseJoinColumns=
                @JoinColumn(name="produtoId", referencedColumnName="id")
        )
    @OneToMany
    private List<Produto> listaProdutos;
    
}
