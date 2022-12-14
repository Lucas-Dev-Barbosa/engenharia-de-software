package com.ddd.ticket.model.domain;

import com.ddd.ticket.model.vos.Cargo;
import com.ddd.ticket.model.vos.Email;
import com.ddd.ticket.model.vos.Name;

public class User {

	private Long id;
	private Name name;
	private Email email;
	private Cargo cargo;

	protected User() {
	}

	public User(Name name, Email email, Cargo cargo) throws Exception {
		if (name == null || email == null)
			throw new Exception("Um user nao pode ficar sem um name e um email");
		
		this.name = name;
		this.email = email;
		this.cargo = cargo == null ? Cargo.CLIENTE : cargo;
	}

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	protected void setName(Name name) {
		this.name = name;
	}

	public Email getEmail() {
		return email;
	}

	protected void setEmail(Email email) {
		this.email = email;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	protected void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
