package br.edu.infnet.lucas.model.domain;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
	
	public boolean hasRole(String role) {
		return this.getRoles()
					.stream()
					.anyMatch((r) -> r.getNome().contains(role));
	}
}
