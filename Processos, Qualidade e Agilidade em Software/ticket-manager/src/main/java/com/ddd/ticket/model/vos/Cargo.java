package com.ddd.ticket.model.vos;

public enum Cargo {

	CLIENTE("Cliente"), ATENDENTE("Atendente"), GERENTE("Gerente"), SISTEMA("Sistema");

	private String descricao;

	Cargo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
