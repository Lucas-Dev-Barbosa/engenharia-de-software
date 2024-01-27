package br.com.bookstock.model.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.Estoque;
import br.com.bookstock.model.domain.repository.EstoqueRepository;

@Service
public class EstoqueService implements EstoqueBkService<Estoque> {

	private final EstoqueRepository estoqueRepository;
	
	public EstoqueService(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}

	@Override
	public List<Estoque> getListaEstoque() {
		return estoqueRepository.findAll();
	}

	@Override
	public Estoque obterEstoquePorId(Long id) throws BookStockException {
		return getEstoqueById(id);
	}

	@Override
	public Estoque editarEstoque(Long id, Estoque estoque) throws BookStockException {
		getEstoqueById(id);
		estoque.setId(id);
		return estoqueRepository.save(estoque);
	}
	
	private Estoque getEstoqueById(Long id) throws BookStockException {
		return estoqueRepository.findById(id).orElseThrow(() -> new BookStockException("Estoque nao encontrado"));
	}

}
