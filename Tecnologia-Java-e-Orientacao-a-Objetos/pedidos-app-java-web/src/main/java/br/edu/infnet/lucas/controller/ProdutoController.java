package br.edu.infnet.lucas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.lucas.model.domain.Bebida;
import br.edu.infnet.lucas.model.domain.Comida;
import br.edu.infnet.lucas.model.domain.Produto;
import br.edu.infnet.lucas.model.domain.Sobremesa;
import br.edu.infnet.lucas.service.IProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
    private IProdutoService produtoService;

    @GetMapping("/lista")
    public ModelAndView listaProdutos(ModelAndView modelAndView) {
    	modelAndView.addObject("produtos", produtoService.listaProduto());
    	modelAndView.setViewName("produtos/list-produtos");
        return modelAndView;
    }
    
    @GetMapping("/new")
    public String produto(Model model) {
    	return "produtos/produto";
    }
    
    @PostMapping("/bebida/salva")
    public String insertBebida(Bebida produto) {
        produtoService.insertProduto(produto);
        return "redirect:/produtos/lista";
    }
    
    @PostMapping("/comida/salva")
    public String insertComida(Comida produto) {
        produtoService.insertProduto(produto);
        return "redirect:/produtos/lista";
    }
    
    @PostMapping("/sobremesa/salva")
    public String insertSobremesa(Sobremesa produto) {
        produtoService.insertProduto(produto);
        return "redirect:/produtos/lista";
    }

    @GetMapping("/produto/{idProduto}")
    public String getProdutoById(@PathVariable(name = "idProduto") Long id, Model model) {
    	model.addAttribute("produto", produtoService.getProdutoById(id));
    	return "produtos/produto"; 
    }

    @GetMapping("/{idProduto}/delete")
    public String deleteProdutoById(@PathVariable(name = "idProduto") Long id) {
        produtoService.deleteProdutoById(id);
        return "redirect:/produtos/lista";
    }

    @PutMapping
    public Produto updateProduto(@RequestBody Produto produto) {
        return produtoService.updateProduto(produto);
    }

}
