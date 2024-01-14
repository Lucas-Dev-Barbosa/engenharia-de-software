package br.com.bookstock.config;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bookstock.model.domain.Autor;
import br.com.bookstock.model.domain.LivroFisico;
import br.com.bookstock.model.domain.dto.request.LivroFisicoDTORequest;
import br.com.bookstock.model.domain.dto.response.LivroFisicoDTOResponse;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		configMapperToLivroFisicoDTOResponse(modelMapper);
		configMapperToLivroFisicoDTORequest(modelMapper);
		
		return modelMapper;
	}
	
	private void configMapperToLivroFisicoDTOResponse(ModelMapper modelMapper) {
		Converter<List<Autor>, List<Long>> listaAutoresConverter = ctx
				-> ctx.getSource().stream().map(autor -> autor.getId()).collect(Collectors.toList());
				
		modelMapper.createTypeMap(LivroFisico.class, LivroFisicoDTOResponse.class)
			.addMappings(mapper -> mapper.using(listaAutoresConverter)
			.map(LivroFisico::getAutores, LivroFisicoDTOResponse::setAutoresId));
	}
	
	private void configMapperToLivroFisicoDTORequest(ModelMapper modelMapper) {
		Converter<List<Long>, List<Autor>> listaAutoresConverter = ctx
				-> ctx.getSource().stream().map(autorId -> {
					Autor autor = new Autor();
					autor.setId(autorId);
					return autor;
				}).collect(Collectors.toList());
				
		modelMapper.createTypeMap(LivroFisicoDTORequest.class, LivroFisico.class)
			.addMappings(mapper -> mapper.using(listaAutoresConverter)
					.map(LivroFisicoDTORequest::getAutoresId, LivroFisico::setAutores))
			
			.addMappings(mapper -> mapper.<Long>map(src -> src.getEditoraId(), (dest, value) -> dest.getEditora().setId(value)))
			
			.addMappings(mapper -> mapper.skip(LivroFisico::setId));
	}
	
}
