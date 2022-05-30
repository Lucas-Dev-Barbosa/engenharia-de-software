package br.edu.infnet.votalucasbarbosa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.votalucasbarbosa.model.domain.Candidato;
import br.edu.infnet.votalucasbarbosa.model.domain.service.CandidatoService;

//Classe que será carregada sempre quando a aplicação iniciar
@Component
public class CandidatoLoader implements ApplicationRunner {

	@Autowired
	private CandidatoService candidatoservice;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Candidato candidato = new Candidato();
		candidato.setNome("Lucas da Silva Barbosa");
		candidato.setNumero(7070);

		try {
			candidatoservice.incluir(candidato);
			System.out.println("Sucesso - inclusao realizada!!");
		} catch (Exception e) {
			System.err.println("[ERRO] " + e.getMessage());
		}
	}

}
