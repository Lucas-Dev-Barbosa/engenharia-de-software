package br.edu.infnet.lucas.model.domain;

import br.edu.infnet.lucas.model.domain.vos.Cpf;
import br.edu.infnet.lucas.model.domain.vos.Email;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Solicitante {

    private String nome;
    private Cpf cpf;
    private Email email;

    public Solicitante(
            @JsonProperty("nome") String nome,
            @JsonProperty("cpf") Cpf cpf,
            @JsonProperty("email") Email email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
