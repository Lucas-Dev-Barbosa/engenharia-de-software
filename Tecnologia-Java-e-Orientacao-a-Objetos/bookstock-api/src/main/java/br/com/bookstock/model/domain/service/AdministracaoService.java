package br.com.bookstock.model.domain.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bookstock.model.domain.EBook;
import br.com.bookstock.model.domain.Livro;
import br.com.bookstock.model.domain.LivroFisico;
import br.com.bookstock.utils.AppFileWriter;

@Service
public class AdministracaoService {
	
	private final String BASE_PATH_FILE = "/src/main/resources/relatorios/";
	private final String NAME_FILE = "relatorio-bookstock.csv";
	
	private final String FULL_PATH_FILE = BASE_PATH_FILE + NAME_FILE;
	
	private final TituloService<EBook> ebookService;
	private final TituloService<LivroFisico> livroFisicoService;
	
	private final AppFileWriter<List<List<String>>> appFileWriter;
	
	public AdministracaoService(TituloService<EBook> ebookService, 
								TituloService<LivroFisico> livroFisicoService, 
								AppFileWriter<List<List<String>>> appFileWriter) {
		
		this.ebookService = ebookService;
		this.livroFisicoService = livroFisicoService;
		this.appFileWriter = appFileWriter;
	}

	public FileInputStream downloadRelatorio() throws IOException {
		escreverDadosArquivo();
		
		return new FileInputStream(new File("." + FULL_PATH_FILE));
	}
	
	private void escreverDadosArquivo() throws IOException {
		appFileWriter.writeFile(Paths.get(".", FULL_PATH_FILE)
                ,montaConteudoCompletoArquivoCsv());
	}
	
	private List<List<String>> montaConteudoCompletoArquivoCsv() {
        List<List<String>> conteudoCompletoArquivo = new ArrayList<>();
        conteudoCompletoArquivo.add(montaCabecalho());
        conteudoCompletoArquivo.addAll(montaConteudo(ebookService.getListaTitulos()));
        conteudoCompletoArquivo.addAll(montaConteudo(livroFisicoService.getListaTitulos()));

        return conteudoCompletoArquivo;
    }
	
	private List<String> montaCabecalho() {
        List<String> cabecalhoArquivo = new ArrayList<>();
        
        cabecalhoArquivo.add("id_livro");
        cabecalhoArquivo.add("titulo");
        cabecalhoArquivo.add("isbn");
        cabecalhoArquivo.add("editora_id");
        cabecalhoArquivo.add("estoque_id");
        cabecalhoArquivo.add("tipo_livro");
        
        return cabecalhoArquivo;
    }
	
	private List<List<String>> montaConteudo(List<? extends Livro> listaConteudoLivro) {
		List<List<String>> conteudoArquivo = new ArrayList<>();
        
		listaConteudoLivro
                .stream()
                .map(livro -> {
                    List<String> livroList = new ArrayList<>();
                    
                    livroList.add(Long.toString(livro.getId()));
                    livroList.add(livro.getTitulo());
                    livroList.add(livro.getIsbn());
                    livroList.add(Long.toString(livro.getEditora().getId()));
                    livroList.add(Long.toString(livro.getEstoque().getId()));
                    livroList.add(livro.getTipo());

                    return livroList;
                })
                .forEach(conteudoArquivo::add);

        return conteudoArquivo;
    }
	
}
