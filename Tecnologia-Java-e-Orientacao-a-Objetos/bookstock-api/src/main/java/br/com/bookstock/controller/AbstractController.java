package br.com.bookstock.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

@Getter
public abstract class AbstractController<REQ, RES, ENT> {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ENT convertDtoToEntity(REQ source, Class<ENT> destination) {
		return modelMapper.map(source, destination);
	}
	
	public RES convertEntityToDto(ENT source, Class<RES> destination) {
		return modelMapper.map(source, destination);
	}

}
