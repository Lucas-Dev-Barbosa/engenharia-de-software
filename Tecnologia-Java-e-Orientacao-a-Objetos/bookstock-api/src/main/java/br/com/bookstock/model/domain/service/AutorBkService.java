package br.com.bookstock.model.domain.service;

import java.util.List;

import br.com.bookstock.exception.BookStockException;

public interface AutorBkService<T> {
	
	List<T> getListaAutor();
	
	T obterAutorPorId(Long id) throws BookStockException;

	T salvarAutor(T autor) throws BookStockException;

	T editarAutor(Long id, T autor) throws BookStockException;
	
	void excluirAutor(Long id) throws BookStockException;

}
