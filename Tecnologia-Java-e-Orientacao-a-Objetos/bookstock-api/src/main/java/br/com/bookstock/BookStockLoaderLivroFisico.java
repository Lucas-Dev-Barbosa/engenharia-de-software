package br.com.bookstock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.bookstock.model.domain.Autor;
import br.com.bookstock.model.domain.Editora;
import br.com.bookstock.model.domain.Estoque;
import br.com.bookstock.model.domain.LivroFisico;
import br.com.bookstock.model.domain.repository.AutorRepository;
import br.com.bookstock.model.domain.repository.EditoraRepository;
import br.com.bookstock.model.domain.service.TituloService;
import lombok.extern.java.Log;

@Log
@Component
@Order(1)
public class BookStockLoaderLivroFisico implements ApplicationRunner {

	@Autowired
	private TituloService<LivroFisico> livroService;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("Iniciando a API de livros Book Stock Manager...");
		
		LivroFisico livroFisico = new LivroFisico();
		
		livroFisico.setTitulo("Titulo de livro teste");
		livroFisico.setSinopse("Sinopse de livro teste");
		
		
		Autor autor = new Autor();
		autor.setNome("Lucas Barbosa");
		autor.setIdade(30);
		autor.setEndereco("Endereco teste de autor");
		
		Autor newAutor = autorRepository.save(autor);
		
		livroFisico.setAutores(Arrays.asList(newAutor));
		
		livroFisico.setIsbn("isbn-"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyhhmmss")));
		
		Editora editora = new Editora();
		editora.setCnpj("123456000125");
		editora.setEndereco("Endereco teste Editora");
		editora.setRazaoSocial("Editora Teste");
		
		Editora newEditora = editoraRepository.save(editora);
		
		livroFisico.setEditora(newEditora);
		
		livroFisico.setPreco("25.10");
		livroFisico.setDataPublicacao(new Date());
		livroFisico.setNumeroPaginas(130);
		
		livroFisico.setTipoCapa("Capa dura");
		livroFisico.setDimensoes("50x50");
		livroFisico.setTipoPapel("Polen");
		
		livroFisico.setEstoque(new Estoque());
		
		livroService.salvarTitulo(livroFisico);
	}

}
