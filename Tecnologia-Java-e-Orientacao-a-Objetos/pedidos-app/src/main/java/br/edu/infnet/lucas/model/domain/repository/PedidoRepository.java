package br.edu.infnet.lucas.model.domain.repository;

import br.edu.infnet.lucas.file.IAppFileReader;
import br.edu.infnet.lucas.file.IAppFileWriter;
import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.Produto;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class PedidoRepository extends AbstractRepository<Pedido>{

    private final IAppFileReader<Pedido> appFileReader;
    private final IAppFileWriter<List<List<String>>> appFileWriter;

    private final String BASE_PATH_FILE = "/src/main/resources/";

    public PedidoRepository(final IAppFileReader<Pedido> appFileReader,
                            final IAppFileWriter<List<List<String>>> appFileWriter) {
        this.appFileReader = appFileReader;
        this.appFileWriter = appFileWriter;
    }

    @PostConstruct
    public void config() throws PedidoException, IOException {
        insert(leDadosArquivo());

        escreveDadosArquivo();
    }

    private Pedido leDadosArquivo() throws PedidoException {
        return appFileReader
                .readFile(Paths.get(".", BASE_PATH_FILE + "pedidos.json"), Pedido.class);
    }

    private void escreveDadosArquivo() throws IOException {
        appFileWriter.writeFile(Paths.get(".", BASE_PATH_FILE + "pedidos-processados.csv")
                ,montaConteudoCompletoArquivoCsv());
    }

    private List<List<String>> montaConteudoCompletoArquivoCsv() {
        List<List<String>> conteudoCompletoArquivo = new ArrayList<>();
        conteudoCompletoArquivo.add(montaCabecalho());
        conteudoCompletoArquivo.addAll(montaConteudo());

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

    private List<List<String>> montaConteudo() {
        Set<Pedido> pedidos = getList();

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
