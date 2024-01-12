package br.com.bookstock.model.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.Livro;
import br.com.bookstock.model.domain.LivroFisico;
import br.com.bookstock.model.domain.repository.LivroFisicoRepository;
import lombok.extern.java.Log;

@Log
@Service
public class LivroFisicoService {

	private final LivroFisicoRepository repository;
	
	public LivroFisicoService(LivroFisicoRepository repository) {
		this.repository = repository;
	}

	public List<LivroFisico> getListaLivros() {
		return repository.findAll();
	}
	
	public LivroFisico obterLivroPorId(Long id) throws BookStockException {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Transactional(readOnly = false)
	public LivroFisico salvarLivro(LivroFisico livro) throws BookStockException {
		return repository.save(livro);
		
//		Map<String, Long> livroMap = new HashMap<>();
//		livroMap.put("id-livro", newLivro.getId());
//		
//		ResponseEntity<String> estoqueEntity = null;
//		try {
////			estoqueEntity = restTemplate.postForEntity(PATH_API_ESTOQUE + "/livro", livroMap, String.class);
//		} catch (RestClientException e) {
//			processaErroGeracaoEstoqueClient(livro.getId(), e.getMessage());
//		}
//
//		if (estoqueEntity.getStatusCodeValue() != 201)
//			processaErroGeracaoEstoqueClient(livro.getId(), "Codigo do status retornado[" + estoqueEntity.getStatusCodeValue() + "]");
//
//		String estoque = estoqueEntity.getBody();
//		log.info("Estoque gerado para o livro:");
//		log.info(estoque);
		
//		return newLivro;
	}

	private void processaErroGeracaoEstoqueClient(Long id, String message) throws BookStockException {
		String erro = "Erro no processo de geração do estoque, excluindo livro da base.";
		log.info(erro);
		log.info(message);
		repository.deleteById(id);
		throw new BookStockException(erro);
	}

	@Transactional(readOnly = false)
	public LivroFisico editarLivro(LivroFisico livro) {
		if (livro != null)
			log.info("Editando informacoes do livro [" + livro.getTitulo() + "] no estoque");

		return repository.save(livro);
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
