package com.ddd.ticket.model.domain;

public class Product {

	private Long id;
	private String descrição;

	protected Product() {
	}

	public Product(String descrição) throws Exception {
		if (descrição == null || descrição.isBlank())
			throw new Exception("Preencha a descricao do produto");
		
		this.descrição = descrição;
	}

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public String getDescrição() {
		return descrição;
	}

	protected void setDescrição(String descrição) {
		this.descrição = descrição;
	}

}
