package br.com.bookstock.model.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.Autor;
import br.com.bookstock.model.domain.repository.AutorRepository;

@Service
public class AutorService implements AutorBkService<Autor> {
	
	private final AutorRepository autorRepository;
	
	public AutorService(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public List<Autor> getListaAutor() {
		return autorRepository.findAll();
	}

	@Override
	public Autor obterAutorPorId(Long id) throws BookStockException {
		return getAutorById(id);
	}

	@Override
	public Autor salvarAutor(Autor autor) throws BookStockException {
		return autorRepository.save(autor);
	}

	@Override
	public Autor editarAutor(Long id, Autor autor) throws BookStockException {
		getAutorById(id);
		autor.setId(id);
		return autorRepository.save(autor);
	}

	@Override
	public void excluirAutor(Long id) throws BookStockException {
		Autor autor = getAutorById(id);
		autorRepository.delete(autor);
	}
	
	private Autor getAutorById(Long id) throws BookStockException {
		return autorRepository.findById(id).orElseThrow(() -> new BookStockException("Autor nao encontrado"));
	}

}
