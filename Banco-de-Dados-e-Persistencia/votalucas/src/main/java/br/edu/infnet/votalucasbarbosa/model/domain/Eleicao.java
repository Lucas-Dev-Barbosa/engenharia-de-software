package br.edu.infnet.votalucasbarbosa.model.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Eleicao {

	private Integer id;
	private LocalDateTime data;
	private String descricao;

	private List<Voto> votos;

	private List<Candidato> candidatos;

	public Eleicao() {
		this.setData(LocalDateTime.now());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

}
