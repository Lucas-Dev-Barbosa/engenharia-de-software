package br.edu.infnet.votalucasbarbosa;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.votalucasbarbosa.model.domain.Eleicao;
import br.edu.infnet.votalucasbarbosa.model.domain.service.EleicaoService;

//Classe que será carregada sempre quando a aplicação iniciar
@Component
public class EleicaoLoader implements ApplicationRunner {

	@Autowired
	private EleicaoService eleicaoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Eleicao eleicao = new Eleicao();
		eleicao.setData(LocalDateTime.of(2022, 1, 28, 8, 20));
		eleicao.setDescricao("Teste de inserção de eleição.");

		try {
			eleicaoService.incluir(eleicao);
			System.out.println("Sucesso - inclusao realizada!!");
		} catch (Exception e) {
			System.err.println("[ERRO] " + e.getMessage());
		}

	}

}
