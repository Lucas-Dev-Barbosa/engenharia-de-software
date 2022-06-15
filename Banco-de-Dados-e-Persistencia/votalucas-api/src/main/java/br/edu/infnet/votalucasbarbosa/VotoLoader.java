package br.edu.infnet.votalucasbarbosa;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import br.edu.infnet.votalucasbarbosa.model.domain.Voto;
import br.edu.infnet.votalucasbarbosa.model.domain.service.VotoService;

//Classe que será carregada sempre quando a aplicação iniciar
@Component
public class VotoLoader  {
	
	@Autowired
	private VotoService votoService;

	public void run(ApplicationArguments args) throws Exception {
		Voto voto = new Voto();
		voto.setLocalizacao("Rio de Janeiro");
		voto.setData(LocalDateTime.of(2022, 1, 28, 8, 20));
		
		try {
			votoService.incluir(voto);
			System.out.println("Sucesso - inclusao realizada!!");
		} catch (Exception e) {
			System.err.println("[ERRO] " + e.getMessage());
		}
		
	}

}
