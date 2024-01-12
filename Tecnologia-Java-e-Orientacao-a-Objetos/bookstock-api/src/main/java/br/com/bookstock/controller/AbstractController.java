package br.com.bookstock.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

@Getter
public abstract class AbstractController<REQ, RES> {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Object convertDtoToEntity(REQ typeParameterReq) {
		return modelMapper.map(typeParameterReq, Object.class);
	}
	
	public RES convertEntityToDto(Object obj, Class<RES> typeParameterRes) {
		return modelMapper.map(obj, typeParameterRes);
	}

}
