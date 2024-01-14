package br.com.bookstock.model.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.Autor;
import br.com.bookstock.model.domain.Estoque;
import br.com.bookstock.model.domain.Livro;
import br.com.bookstock.model.domain.LivroFisico;
import br.com.bookstock.model.domain.repository.AutorRepository;
import br.com.bookstock.model.domain.repository.EditoraRepository;
import br.com.bookstock.model.domain.repository.LivroFisicoRepository;
import lombok.extern.java.Log;

@Log
@Service
public class LivroFisicoService {

	private final LivroFisicoRepository repository;
	private final AutorRepository autorRepository;
	private final EditoraRepository editoraRepository;
	
	
	public LivroFisicoService(LivroFisicoRepository repository, AutorRepository autorRepository, EditoraRepository editoraRepository) {
		this.repository = repository;
		this.autorRepository = autorRepository;
		this.editoraRepository = editoraRepository;
	}

	public List<LivroFisico> getListaLivros() {
		return repository.findAll();
	}
	
	public LivroFisico obterLivroPorId(Long id) throws BookStockException {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Transactional(readOnly = false)
	public LivroFisico salvarLivro(LivroFisico livro) throws BookStockException {
		validaAutores(livro);
		validaEditora(livro);
		
		livro.setEstoque(new Estoque());
		
		return repository.save(livro);
	}

	@Transactional(readOnly = false)
	public LivroFisico editarLivro(LivroFisico livro) throws BookStockException {
		validaAutores(livro);
		validaEditora(livro);

		return repository.save(livro);
	}
	
	private void validaAutores(LivroFisico livro) throws BookStockException {
		for(Autor autor : livro.getAutores()) {
			autorRepository.findById(autor.getId()).orElseThrow(() -> new BookStockException("O autor nao existe"));
		}
 	}
	
	private void validaEditora(LivroFisico livro) throws BookStockException {
		editoraRepository.findById(livro.getEditora().getId()).orElseThrow(() -> new BookStockException("A editora nao existe"));
	}

	@Transactional(readOnly = false)
	public void excluirTitulo(Long id) throws BookStockException {
		log.info("Excluindo livro ID [" + id + "] da base");
		Livro livro = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		try {
//			restTemplate.delete(PATH_API_ESTOQUE + "/" + livro.getId());
			repository.deleteById(livro.getId());
		} catch (Exception e) {
			String erro = "Erro no processo de exclusão do título.";
			log.info(erro);
			throw new BookStockException(erro);
		}
	}

}
