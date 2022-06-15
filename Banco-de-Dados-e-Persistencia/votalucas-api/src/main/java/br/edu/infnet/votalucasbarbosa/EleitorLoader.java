package br.edu.infnet.votalucasbarbosa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleitor;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleitorService;

//Classe que será carregada sempre quando a aplicação iniciar
@Component
public class EleitorLoader {
	
	@Autowired
	private EleitorService eleitorService;

	public void run(ApplicationArguments args) throws Exception {

		Eleitor eleitor = new Eleitor();
		eleitor.setNome("Lucas Barbosa");
		eleitor.setEmail("lucas.teste@email.com");
		eleitor.setTelefone("7788996655");
		eleitor.setToken("xxxxxxxxxxx");
		
		try {
			eleitorService.incluir(eleitor);
			System.out.println("Sucesso - inclusao realizada!!");
		} catch (Exception e) {
			System.err.println("[ERRO] " + e.getMessage());
		}
		
	}

}
