package br.edu.infnet.votalucasbarbosa.clients.votaclient;


public interface VotaApi {

	public final String URL = "http://localhost:8080/api";
	
	public final String PATH_CANDIDATOS = "/candidatos";
	public final String CANDIDATOS_NAME_CLIENT = "candidatos-endpoint";
	
	public final String PATH_ELEICOES = "/eleicoes";
	public final String ELEICOES_NAME_CLIENT = "eleicoes-endpoint";
	
	public final String PATH_ELEITORES = "/eleitores";
	public final String ELEITORES_NAME_CLIENT = "eleitores-endpoint";
	
	public final String PATH_VOTOS = "/votos";
	public final String VOTOS_NAME_CLIENT = "votos-endpoint";
	
}
