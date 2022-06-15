package br.edu.infnet.votalucasbarbosa.info;

public class InfoApi {

	private String nomeApi = InfoApiEnum.NOME_API.getTexto();
	private String infoApi = InfoApiEnum.INFO_API.getTexto();
	
	public String getNomeApi() {
		return nomeApi;
	}
	
	public String getInfoApi() {
		return infoApi;
	}
	
}
