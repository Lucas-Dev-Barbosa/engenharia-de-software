package br.com.bookstock.model.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.EBook;

@Service
public class EBookService implements TituloService<EBook>{

	@Override
	public List<EBook> getListaTitulos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EBook obterTituloPorId(Long id) throws BookStockException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EBook salvarTitulo(EBook titulo) throws BookStockException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EBook editarTitulo(Long id, EBook titulo) throws BookStockException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirTitulo(Long id) throws BookStockException {
		// TODO Auto-generated method stub
		
	}

}
