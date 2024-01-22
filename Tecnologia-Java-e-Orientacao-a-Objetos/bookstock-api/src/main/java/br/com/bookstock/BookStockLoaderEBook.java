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
import br.com.bookstock.model.domain.EBook;
import br.com.bookstock.model.domain.Editora;
import br.com.bookstock.model.domain.Estoque;
import br.com.bookstock.model.domain.repository.AutorRepository;
import br.com.bookstock.model.domain.repository.EditoraRepository;
import br.com.bookstock.model.domain.service.TituloService;
import lombok.extern.java.Log;

@Log
@Component
@Order(2)
public class BookStockLoaderEBook implements ApplicationRunner {

	@Autowired
	private TituloService<EBook> tituloService;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("Cadastrando um EBook na base...");
		
		EBook livroFisico = new EBook();
		
		livroFisico.setTitulo("Titulo de EBook teste");
		livroFisico.setSinopse("Sinopse de Ebook teste");
		
		
		Autor autor = new Autor();
		autor.setNome("Lucas Silva");
		autor.setIdade(30);
		autor.setEndereco("Endereco do autor do Ebook");
		
		Autor newAutor = autorRepository.save(autor);
		
		livroFisico.setAutores(Arrays.asList(newAutor));
		
		livroFisico.setIsbn("isbn-"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyhhmmssa")));
		
		Editora editora = new Editora();
		editora.setCnpj("987654321123");
		editora.setEndereco("Endereco da Editora do Ebook");
		editora.setRazaoSocial("Editora do Ebook");
		
		Editora newEditora = editoraRepository.save(editora);
		
		livroFisico.setEditora(newEditora);
		
		livroFisico.setPreco("50.00");
		livroFisico.setDataPublicacao(new Date());
		livroFisico.setNumeroPaginas(230);
		
		livroFisico.setTamanhoArquivo(250l);
		livroFisico.setFormato("PDF");
		livroFisico.setTipoFonte("Arial");
		
		livroFisico.setEstoque(new Estoque());
		
		tituloService.salvarTitulo(livroFisico);
	}

}
