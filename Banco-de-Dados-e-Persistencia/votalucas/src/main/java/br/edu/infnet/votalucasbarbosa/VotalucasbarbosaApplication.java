package br.edu.infnet.votalucasbarbosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VotalucasbarbosaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VotalucasbarbosaApplication.class, args);
	}

}
