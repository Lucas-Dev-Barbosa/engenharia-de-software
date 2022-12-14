package com.ddd.ticket.model.vos;

public enum Priority {
	
	LOW("Low"), MEDIUM("Medium"), HIGH("High");
	
	private String descricao;
	
	Priority(String descricao) {
		this.descricao = descricao;
	}
		
	public String getDescricao() {
		return descricao;
	}

}
