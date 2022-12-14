package com.ddd.ticket.model.vos;

public enum Status {
	
	ABERTO("Aberto"), EM_ANDAMENTO("Aberto"), FECHADO("Aberto");
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}
		
	public String getDescricao() {
		return descricao;
	}

}
