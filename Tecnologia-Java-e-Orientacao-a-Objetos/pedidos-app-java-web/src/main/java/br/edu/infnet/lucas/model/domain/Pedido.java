package br.edu.infnet.lucas.model.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @OneToMany(mappedBy = "pedido")
    private List<Produto> listaProdutos;
    
}
