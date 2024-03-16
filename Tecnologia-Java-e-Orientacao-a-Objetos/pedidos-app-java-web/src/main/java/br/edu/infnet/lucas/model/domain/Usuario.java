package br.edu.infnet.lucas.model.domain;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.edu.infnet.lucas.model.domain.vos.Email;
import lombok.Data;

@Data
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Embedded
    private Email email;
	
	private String password;
	
	private String nome;
	
	private Integer status;
	
	@ManyToMany
	private Set<Role> roles;
}
