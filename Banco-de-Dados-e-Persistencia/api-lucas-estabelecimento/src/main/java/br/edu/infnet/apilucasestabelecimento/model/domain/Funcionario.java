package br.edu.infnet.apilucasestabelecimento.model.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TFuncionario", uniqueConstraints = @UniqueConstraint(columnNames={"cpf"}))
public class Funcionario extends Usuario {

	private String cpf;
	private String email;
	private String telefone;

	@JsonBackReference //Usado para evitar a recursão infinita no momento em que for montado o json
	@ManyToOne
	@JoinColumn(name = "idEstabelecimento")
	private Estabelecimento estabelecimento;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
}
