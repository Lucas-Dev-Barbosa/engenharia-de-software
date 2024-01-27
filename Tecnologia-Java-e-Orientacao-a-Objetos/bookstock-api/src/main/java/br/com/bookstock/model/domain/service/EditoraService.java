package br.com.bookstock.model.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bookstock.exception.BookStockException;
import br.com.bookstock.model.domain.Editora;
import br.com.bookstock.model.domain.repository.EditoraRepository;

@Service
public class EditoraService implements EditoraBkService<Editora> {
	
	private final EditoraRepository editoraRepository;
	
	public EditoraService(EditoraRepository editoraRepository) {
		this.editoraRepository = editoraRepository;
	}

	@Override
	public List<Editora> getListaEditora() {
		return editoraRepository.findAll();
	}

	@Override
	public Editora obterEditoraPorId(Long id) throws BookStockException {
		return getEditoraById(id);
	}

	@Override
	public Editora salvarEditora(Editora editora) throws BookStockException {
		return editoraRepository.save(editora);
	}

	@Override
	public Editora editarEditora(Long id, Editora editora) throws BookStockException {
		getEditoraById(id);
		editora.setId(id);
		return editoraRepository.save(editora);
	}

	@Override
	public void excluirEditora(Long id) throws BookStockException {
		Editora editora = getEditoraById(id);
		editoraRepository.delete(editora);
	}
	
	private Editora getEditoraById(Long id) throws BookStockException {
		return editoraRepository.findById(id).orElseThrow(() -> new BookStockException("Editora nao encontrada"));
	}

}
