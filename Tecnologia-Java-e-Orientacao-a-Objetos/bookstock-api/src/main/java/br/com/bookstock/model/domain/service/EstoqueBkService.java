package br.com.bookstock.model.domain.service;

import java.util.List;

import br.com.bookstock.exception.BookStockException;

public interface EstoqueBkService<T> {

	List<T> getListaEstoque();
	
	T obterEstoquePorId(Long id) throws BookStockException;

	T editarEstoque(Long id, T estoque) throws BookStockException;
	
}
