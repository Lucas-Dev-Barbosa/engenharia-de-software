package br.edu.infnet.lucas.service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.infnet.lucas.file.IAppFileReader;
import br.edu.infnet.lucas.file.IAppFileWriter;
import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.Produto;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;

@Component
public class FileService {
	
	private final String BASE_PATH_FILE = "/src/main/resources/";
	
	@Autowired
	private IAppFileReader<Pedido> appFileReader;
    
	@Autowired
	private IAppFileWriter<List<List<String>>> appFileWriter;
	
	public Pedido leDadosArquivo() throws PedidoException {
        return appFileReader
                .readFile(Paths.get(".", BASE_PATH_FILE + "pedidos.json"), Pedido.class);
    }

    public void escreveDadosArquivo(List<Pedido> pedidos) throws IOException {
        appFileWriter.writeFile(Paths.get(".", BASE_PATH_FILE + "pedidos-processados.csv")
                ,montaConteudoCompletoArquivoCsv(pedidos));
    }

    private List<List<String>> montaConteudoCompletoArquivoCsv(List<Pedido> pedidos) {
        List<List<String>> conteudoCompletoArquivo = new ArrayList<>();
        conteudoCompletoArquivo.add(montaCabecalho());
        conteudoCompletoArquivo.addAll(montaConteudo(pedidos));

        return conteudoCompletoArquivo;
    }

    private List<String> montaCabecalho() {
        List<String> cabecalhoArquivo = new ArrayList<>();
        cabecalhoArquivo.add("descricaoPedido");
        cabecalhoArquivo.add("nomeSolicitante");
        cabecalhoArquivo.add("emailSolicitante");
        cabecalhoArquivo.add("cpfSolicitante");
        cabecalhoArquivo.add("produtos");

        return cabecalhoArquivo;
    }

    private List<List<String>> montaConteudo(List<Pedido> pedidos) {
        List<List<String>> conteudoArquivo = new ArrayList<>();
        pedidos
                .stream()
                .map(pedido -> {
                    List<String> pedidoList = new ArrayList<>();
                    pedidoList.add(pedido.getDescricao());
                    pedidoList.add(pedido.getSolicitante().getNome());
                    pedidoList.add(pedido.getSolicitante().getEmail().getEmailAddress());
                    pedidoList.add(pedido.getSolicitante().getCpf().getCpf());
                    pedidoList.add(pedido
                            .getListaProdutos()
                            .stream()
                            .map(Produto::getNome)
                            .reduce("", (partialValue, element) -> partialValue + "," + element)
                            .substring(1));

                    return pedidoList;
                })
                .forEach(conteudoArquivo::add);

        return conteudoArquivo;
    }

}
