package br.com.bookstock.model.domain.service;

import java.util.List;

import br.com.bookstock.exception.BookStockException;

public interface EditoraBkService<T> {

	List<T> getListaEditora();
	
	T obterEditoraPorId(Long id) throws BookStockException;

	T salvarEditora(T editora) throws BookStockException;

	T editarEditora(Long id, T editora) throws BookStockException;
	
	void excluirEditora(Long id) throws BookStockException;
	
}
