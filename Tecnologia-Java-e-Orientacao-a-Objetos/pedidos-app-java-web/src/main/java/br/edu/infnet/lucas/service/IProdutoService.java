package br.edu.infnet.lucas.service;

import java.util.List;

import br.edu.infnet.lucas.model.domain.Produto;

public interface IProdutoService {
	
	Produto getProdutoById(Long id);

	Produto insertProduto(Produto produto);

    void deleteProdutoById(Long id);

    Produto updateProduto(Produto produto);

    List<Produto> listaProduto();

}
