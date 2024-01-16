package br.com.bookstock.model.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.Autor;
import br.com.bookstock.model.domain.Estoque;
import br.com.bookstock.model.domain.Livro;
import br.com.bookstock.model.domain.LivroFisico;
import br.com.bookstock.model.domain.repository.AutorRepository;
import br.com.bookstock.model.domain.repository.EditoraRepository;
import br.com.bookstock.model.domain.repository.EstoqueRepository;
import br.com.bookstock.model.domain.repository.LivroFisicoRepository;

@Service
public class LivroFisicoService implements TituloService<LivroFisico> {

	private final LivroFisicoRepository livroRepository;
	private final AutorRepository autorRepository;
	private final EditoraRepository editoraRepository;
	
	public LivroFisicoService(LivroFisicoRepository livroRepository, 
								AutorRepository autorRepository, 
								EditoraRepository editoraRepository, 
								EstoqueRepository estoqueRepository) {
		
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
		this.editoraRepository = editoraRepository;
	}

	@Override
	public List<LivroFisico> getListaTitulos() {
		return livroRepository.findAll();
	}

	@Override
	public LivroFisico obterTituloPorId(Long id) throws BookStockException {
		return getLivroById(id);
	}

	@Transactional(readOnly = false)
	@Override
	public LivroFisico salvarTitulo(LivroFisico titulo) throws BookStockException {
		validaAutores(titulo);
		validaEditora(titulo);
		
		titulo.setEstoque(new Estoque());
		
		return livroRepository.save(titulo);
	}

	@Transactional(readOnly = false)
	@Override
	public LivroFisico editarTitulo(Long id, LivroFisico titulo) throws BookStockException {
		Livro livroOld = getLivroById(id);
		
		validaAutores(titulo);
		validaEditora(titulo);
		
		titulo.setId(id);
		titulo.setEstoque(livroOld.getEstoque());
		
		return livroRepository.save(titulo);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void excluirTitulo(Long id) throws BookStockException {
		LivroFisico livro = getLivroById(id);
		
		livroRepository.delete(livro);
	}
	
	private LivroFisico getLivroById(Long id) throws BookStockException {
		return livroRepository.findById(id).orElseThrow(() -> new BookStockException("Livro nao encontrado"));
	}
	
	private void validaAutores(LivroFisico livro) throws BookStockException {
		for(Autor autor : livro.getAutores()) {
			autorRepository.findById(autor.getId()).orElseThrow(() -> new BookStockException("O autor nao existe"));
		}
 	}
	
	private void validaEditora(LivroFisico livro) throws BookStockException {
		editoraRepository.findById(livro.getEditora().getId()).orElseThrow(() -> new BookStockException("A editora nao existe"));
	}

}
