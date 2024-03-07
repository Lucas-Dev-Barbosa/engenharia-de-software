package br.edu.infnet.lucas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.lucas.model.domain.Produto;
import br.edu.infnet.lucas.model.domain.repository.ProdutoRepository;

@Service
public class ProdutoService implements IProdutoService {

	@Autowired
    private ProdutoRepository produtoRepository;
	
	@Override
    public List<Produto> listaProduto() {
        return new ArrayList<>(produtoRepository.findAll());
    }

    @Override
    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public Produto insertProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deleteProdutoById(Long id) {
    	Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }

    @Override
    public Produto updateProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

}
