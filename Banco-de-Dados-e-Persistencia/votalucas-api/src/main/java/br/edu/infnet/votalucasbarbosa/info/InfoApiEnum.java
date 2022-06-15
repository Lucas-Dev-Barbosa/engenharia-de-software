package br.edu.infnet.votalucasbarbosa.info;

public enum InfoApiEnum {

	NOME_API("Vota Lucas Api"),
	INFO_API("API relacionada ao processo de votação e cadastramento de Eleições, Eleitores, Candidatos e Votos!");
	
	private String texto;
	
	private InfoApiEnum(String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
	
}
