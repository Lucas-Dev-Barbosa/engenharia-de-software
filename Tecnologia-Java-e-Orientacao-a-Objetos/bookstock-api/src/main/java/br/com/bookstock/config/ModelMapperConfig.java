package br.com.bookstock.config;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bookstock.model.domain.Autor;
import br.com.bookstock.model.domain.EBook;
import br.com.bookstock.model.domain.LivroFisico;
import br.com.bookstock.model.domain.dto.request.EBookDTORequest;
import br.com.bookstock.model.domain.dto.request.LivroFisicoDTORequest;
import br.com.bookstock.model.domain.dto.response.EBookDTOResponse;
import br.com.bookstock.model.domain.dto.response.LivroFisicoDTOResponse;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		configMapperToLivroFisicoDTOResponse(modelMapper);
		configMapperToLivroFisicoDTORequest(modelMapper);
		
		configMapperToEBookDTOResponse(modelMapper);
		configMapperToEBookDTORequest(modelMapper);
		
		return modelMapper;
	}
	
	private void configMapperToLivroFisicoDTOResponse(ModelMapper modelMapper) {
		modelMapper.createTypeMap(LivroFisico.class, LivroFisicoDTOResponse.class)
			.addMappings(mapper -> mapper.using(getConverterListAutorToResponse())
			.map(LivroFisico::getAutores, LivroFisicoDTOResponse::setAutoresId));
	}
	
	private void configMapperToLivroFisicoDTORequest(ModelMapper modelMapper) {
		modelMapper.createTypeMap(LivroFisicoDTORequest.class, LivroFisico.class)
			.addMappings(mapper -> mapper.using(getConverterListAutorToRequest())
					.map(LivroFisicoDTORequest::getAutoresId, LivroFisico::setAutores))
			
			.addMappings(mapper -> mapper.<Long>map(src -> src.getEditoraId(), (dest, value) -> dest.getEditora().setId(value)))
			
			.addMappings(mapper -> mapper.skip(LivroFisico::setId));
	}
	
	private void configMapperToEBookDTOResponse(ModelMapper modelMapper) {
		modelMapper.createTypeMap(EBook.class, EBookDTOResponse.class)
			.addMappings(mapper -> mapper.using(getConverterListAutorToResponse())
			.map(EBook::getAutores, EBookDTOResponse::setAutoresId));
	}
	
	private void configMapperToEBookDTORequest(ModelMapper modelMapper) {
		modelMapper.createTypeMap(EBookDTORequest.class, EBook.class)
			.addMappings(mapper -> mapper.using(getConverterListAutorToRequest())
					.map(EBookDTORequest::getAutoresId, EBook::setAutores))
			
			.addMappings(mapper -> mapper.<Long>map(src -> src.getEditoraId(), (dest, value) -> dest.getEditora().setId(value)))
			
			.addMappings(mapper -> mapper.skip(EBook::setId));
	}
	
	private Converter<List<Autor>, List<Long>> getConverterListAutorToResponse() {
		return new Converter<List<Autor>, List<Long>>() {

			@Override
			public List<Long> convert(MappingContext<List<Autor>, List<Long>> context) {
				return context
						.getSource()
						.stream()
						.map(autor -> autor.getId())
						.collect(Collectors.toList());
			}
			
		};
	}
	
	private Converter<List<Long>, List<Autor>> getConverterListAutorToRequest() {
		return new Converter<List<Long>, List<Autor>>() {

			@Override
			public List<Autor> convert(MappingContext<List<Long>, List<Autor>> context) {
				return context.getSource().stream().map(autorId -> {
							Autor autor = new Autor();
							autor.setId(autorId);
							return autor;
						}).collect(Collectors.toList());
			}
			
		};
	}
	
}
