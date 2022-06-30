package br.edu.infnet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppLucasEstabelecimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppLucasEstabelecimentoApplication.class, args);
	}

}
