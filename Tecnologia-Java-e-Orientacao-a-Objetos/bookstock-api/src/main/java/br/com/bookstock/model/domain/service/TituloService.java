package br.com.bookstock.model.domain.service;

import java.util.List;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.Livro;

public interface TituloService<T extends Livro> {

	List<T> getListaTitulos();
	
	T obterTituloPorId(Long id) throws BookStockException;

	T salvarTitulo(T titulo) throws BookStockException;

	T editarTitulo(Long id, T titulo) throws BookStockException;
	
	void excluirTitulo(Long id) throws BookStockException;

}
