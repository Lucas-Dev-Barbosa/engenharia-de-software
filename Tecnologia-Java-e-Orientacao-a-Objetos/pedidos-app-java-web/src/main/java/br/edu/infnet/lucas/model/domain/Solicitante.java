package br.edu.infnet.lucas.model.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.infnet.lucas.model.domain.vos.Cpf;
import br.edu.infnet.lucas.model.domain.vos.Email;
import lombok.Data;

@Data
@Entity
public class Solicitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String nome;
    
    @Embedded
    private Cpf cpf;
    
    @Embedded
    private Email email;

}
