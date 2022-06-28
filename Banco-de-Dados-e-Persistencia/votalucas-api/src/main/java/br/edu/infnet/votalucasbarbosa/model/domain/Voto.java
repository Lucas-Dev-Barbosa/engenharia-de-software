package br.edu.infnet.votalucasbarbosa.model.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TVoto")
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime data;
	
	@NotBlank(message = "Informe a localização do voto")
	private String localizacao;

	@NotNull(message = "É necessário referenciar o ID do eleitor")
	@ManyToOne
	@JoinColumn(name = "idEleitor")
	private Eleitor eleitor;
	
	@NotNull(message = "É necessário referenciar o ID da eleição")
	@ManyToOne
	@JoinColumn(name = "idEleicao")
	private Eleicao eleicao;
	
	@NotNull(message = "É necessário referenciar o ID do candidato")
	@ManyToOne
	@JoinColumn(name = "idCandidato")
	private Candidato candidato;

	public Voto() {
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

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Eleicao getEleicao() {
		return eleicao;
	}

	public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}
