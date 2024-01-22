package br.com.bookstock.model.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.Autor;
import br.com.bookstock.model.domain.EBook;
import br.com.bookstock.model.domain.Estoque;
import br.com.bookstock.model.domain.repository.AutorRepository;
import br.com.bookstock.model.domain.repository.EBookRepository;
import br.com.bookstock.model.domain.repository.EditoraRepository;

@Service
public class EBookService implements TituloService<EBook>{

	private final EBookRepository livroRepository;
	private final AutorRepository autorRepository;
	private final EditoraRepository editoraRepository;
	
	public EBookService(EBookRepository livroRepository, 
						AutorRepository autorRepository, 
						EditoraRepository editoraRepository) {
		
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
		this.editoraRepository = editoraRepository;
	}

	@Override
	public List<EBook> getListaTitulos() {
		return livroRepository.findAll();
	}

	@Override
	public EBook obterTituloPorId(Long id) throws BookStockException {
		return getEBookById(id);
	}

	@Override
	public EBook salvarTitulo(EBook titulo) throws BookStockException {
		validaAutores(titulo);
		validaEditora(titulo);
		
		titulo.setEstoque(new Estoque());
		
		return livroRepository.save(titulo);
	}

	@Override
	public EBook editarTitulo(Long id, EBook titulo) throws BookStockException {
		EBook ebookOld = getEBookById(id);
		
		validaAutores(titulo);
		validaEditora(titulo);
		
		titulo.setId(id);
		titulo.setEstoque(ebookOld.getEstoque());
		
		return livroRepository.save(titulo);
	}

	@Override
	public void excluirTitulo(Long id) throws BookStockException {
		EBook ebook = getEBookById(id);
		
		livroRepository.delete(ebook);
	}
	
	private EBook getEBookById(Long id) throws BookStockException {
		return livroRepository.findById(id).orElseThrow(() -> new BookStockException("Livro nao encontrado"));
	}
	
	private void validaAutores(EBook livro) throws BookStockException {
		for(Autor autor : livro.getAutores()) {
			autorRepository.findById(autor.getId()).orElseThrow(() -> new BookStockException("O autor nao existe"));
		}
 	}
	
	private void validaEditora(EBook livro) throws BookStockException {
		editoraRepository.findById(livro.getEditora().getId()).orElseThrow(() -> new BookStockException("A editora nao existe"));
	}

}
