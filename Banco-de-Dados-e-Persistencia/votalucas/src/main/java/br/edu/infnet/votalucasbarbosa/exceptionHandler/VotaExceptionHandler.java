package br.edu.infnet.votalucasbarbosa.exceptionHandler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;

@ControllerAdvice
public class VotaExceptionHandler {

	@ExceptionHandler(FeignException.BadRequest.class)
	public ModelAndView errorPageBadRequest(FeignException ex, HttpServletResponse response) {
		ErrorMessage errorMessage = converteJson(ex.getMessage());
		
		ModelAndView model = new ModelAndView("error");
		model.addObject("status", errorMessage.getStatus());
		model.addObject("error", "A operação não pode ser realizada");
		model.addObject("message", errorMessage.getMessage());
		
		return model;
	}
	
	private ErrorMessage converteJson(String mensagem) {
		ErrorMessage errorMessage = null;
		
		String mensagemJson = mensagem
				.substring(0, mensagem.length() - 1)
				.substring(mensagem.indexOf("{"));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			errorMessage = mapper.readValue(mensagemJson, ErrorMessage.class);
		} catch (JsonMappingException e) {
			System.out.println("Erro no mapeamento Json: " + e.getMessage());
		} catch (JsonProcessingException e) {
			System.out.println("Erro no processamento Json: " + e.getMessage());
		}
		
		return errorMessage;
	}
	
}
