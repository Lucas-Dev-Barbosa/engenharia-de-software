package br.edu.infnet.lucas.model.domain.repository;

import br.edu.infnet.lucas.file.PropertiesFileReader;
import br.edu.infnet.lucas.model.domain.*;
import br.edu.infnet.lucas.model.domain.exception.CpfInvalidoException;
import br.edu.infnet.lucas.model.domain.exception.EmailInvalidoException;
import br.edu.infnet.lucas.model.domain.vos.Cpf;
import br.edu.infnet.lucas.model.domain.vos.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Repository
public class PedidoRepository extends AbstractRepository<Pedido>{

    @Autowired
    private PropertiesFileReader propertiesFileReader;

    @PostConstruct
    public void leArquivoProperties() throws IOException, EmailInvalidoException, CpfInvalidoException {
        Map<String, String> mapFile = propertiesFileReader
                .readPropertyFile(Paths.get(".", "/src/main/resources/Pedido.properties"));

        Pedido pedidoFile = rowMapper(mapFile);
        insert(pedidoFile);
    }

    private Pedido rowMapper(Map<String, String> mapFile) throws EmailInvalidoException, CpfInvalidoException {
        return montaPedido(mapFile);
    }

    private Pedido montaPedido(Map<String, String> mapFile) throws EmailInvalidoException, CpfInvalidoException {
        String descricao = mapFile.get("pedido.descricao");
        LocalDateTime data = LocalDateTime.now();
        boolean web = Boolean.getBoolean(mapFile.get("pedido.web"));

        return new Pedido(descricao, data, web, montaSolicitante(mapFile), montaListaProdutos(mapFile));
    }

    private Solicitante montaSolicitante(Map<String, String> mapFile) throws CpfInvalidoException, EmailInvalidoException {
        String nome = mapFile.get("pedido.solicitante.nome");
        String cpf = mapFile.get("pedido.solicitante.cpf");
        String email = mapFile.get("pedido.solicitante.email");

        return new Solicitante(nome, new Cpf(cpf), new Email(email));
    }

    private List<Produto> montaListaProdutos(Map<String, String> mapFile) {
        Pattern pattern = Pattern.compile("\\{[\\w+: \\w+,]+\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mapFile.get("pedido.listaProdutos"));

        List<String> linhasProdutosProcessados = getLinhasProdutosFileProperties(matcher);
        List<String> linhasProdutosProcessadoSemChaves = getListaLinhasProdutosSemChaves(linhasProdutosProcessados);
        List<String[]> listaProdutosProcessado = getListaProdutosProcessados(linhasProdutosProcessadoSemChaves);

        return getListaProdutosCompleta(listaProdutosProcessado);
    }

    private List<String> getLinhasProdutosFileProperties(Matcher matcher) {
        List<String> produtosList = new ArrayList<>();

        while(matcher.find()) {
            produtosList.add(matcher.group());
        }

        return produtosList;
    }

    private List<String> getListaLinhasProdutosSemChaves(List<String> produtosList) {
        return produtosList
                .stream()
                .map(produto -> produto
                        .substring(0, produto.length() - 1)
                        .substring(1))
                .collect(Collectors.toList());
    }

    private List<String[]> getListaProdutosProcessados(List<String> produtosList) {
        return produtosList.stream()
                .map(produto -> produto.split(","))
                .collect(Collectors.toList());
    }

    private List<Produto> getListaProdutosCompleta(List<String[]> listaProdutosProcessado) {
        return listaProdutosProcessado
                .stream()
                .map(produtoArr -> {
                    Map<String, String> produtoMap = new HashMap<>();

                    for (String produto : produtoArr) {
                        produtoMap.put(produto.split(":")[0].trim(), produto.split(":")[1].trim());
                    }

                    return produtoMap;
                })
                .map(produtoMap -> {
                    Produto newProduto;
                    String tipo = produtoMap.get("tipo");
                    switch (tipo) {
                        case "bebida":
                            Bebida bebida = new Bebida();

                            constroiProduto(bebida, produtoMap);

                            bebida.setGelada(Boolean.parseBoolean(produtoMap.get("gelada")));
                            bebida.setTamanho(Short.parseShort(produtoMap.get("tamanho")));
                            bebida.setMarca(produtoMap.get("marca"));

                            return bebida;
                        case "comida":
                            Comida comida = new Comida();

                            constroiProduto(comida, produtoMap);

                            comida.setPeso(Float.parseFloat(produtoMap.get("peso")));
                            comida.setVegano(Boolean.parseBoolean(produtoMap.get("vegano")));

                            return comida;
                        case "sobremesa":
                            Sobremesa sobremesa = new Sobremesa();

                            constroiProduto(sobremesa, produtoMap);

                            sobremesa.setQuantidade(Integer.parseInt(produtoMap.get("quantidade")));
                            sobremesa.setDoce(Boolean.parseBoolean(produtoMap.get("doce")));
                            sobremesa.setInformacao(produtoMap.get("informacao"));

                            return sobremesa;
                        default:
                            return null;
                    }
                }).collect(Collectors.toList());
    }

    private void constroiProduto(Produto produto, Map<String, String> produtoMap) {
        produto.setNome(produtoMap.get("nome"));
        produto.setValor(Double.parseDouble(produtoMap.get("valor")));
        produto.setCodigo(Integer.parseInt(produtoMap.get("codigo")));
        produto.setTipo('b');
    }

}
