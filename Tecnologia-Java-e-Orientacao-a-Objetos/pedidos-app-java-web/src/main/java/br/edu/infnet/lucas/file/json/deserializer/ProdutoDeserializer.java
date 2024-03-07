package br.edu.infnet.lucas.file.json.deserializer;

import br.edu.infnet.lucas.model.domain.Bebida;
import br.edu.infnet.lucas.model.domain.Comida;
import br.edu.infnet.lucas.model.domain.Produto;
import br.edu.infnet.lucas.model.domain.Sobremesa;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ProdutoDeserializer extends StdDeserializer<Produto> {

	private static final long serialVersionUID = 1L;

	private String nome;
    private double valor;
    private int codigo;
    private char tipo;
    private Produto produto;

    public ProdutoDeserializer() {
        this(null);
    }

    public ProdutoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Produto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        preencheAtributosProduto(jsonNode);

        defineProdutoPeloTipo(jsonNode);

        return produto;
    }

    public void preencheAtributosProduto(JsonNode jsonNode){
        nome = jsonNode.get("nome").asText();
        valor = jsonNode.get("valor").asDouble();
        codigo = jsonNode.get("codigo").asInt();
        tipo = jsonNode.get("tipo").asText().charAt(0);
    }

    private void montaObjetoBebida(JsonNode jsonNode) {
        Bebida bebida = new Bebida();
        bebida.setGelada(jsonNode.get("gelada").asBoolean());
        bebida.setTamanho(jsonNode.get("tamanho").shortValue());
        bebida.setMarca(jsonNode.get("marca").asText());

        produto = bebida;
    }

    private void montaObjetoComida(JsonNode jsonNode) {
        Comida comida = new Comida();
        comida.setPeso(jsonNode.get("peso").asInt());
        comida.setVegano(jsonNode.get("vegano").asBoolean());
        comida.setIngredientes(jsonNode.get("ingredientes").asText());

        produto = comida;
    }

    private void montaObjetoSobremesa(JsonNode jsonNode) {
        Sobremesa sobremesa = new Sobremesa();
        sobremesa.setQuantidade(jsonNode.get("quantidade").asInt());
        sobremesa.setDoce(jsonNode.get("doce").asBoolean());
        sobremesa.setInformacao(jsonNode.get("informacao").asText());

        produto = sobremesa;
    }

    private void defineProdutoPeloTipo(JsonNode jsonNode) {
        switch (tipo) {
            case 'b':
                montaObjetoBebida(jsonNode);
                break;
            case 'c':
                montaObjetoComida(jsonNode);
                break;
            case 's':
                montaObjetoSobremesa(jsonNode);
                break;
            default:
                produto = null;
        }

        montaObjetoProduto();
    }

    private void montaObjetoProduto() {
        if(produto != null){
            produto.setNome(nome);
            produto.setValor(valor);
            produto.setCodigo(codigo);
            produto.setTipo(tipo);
        }
    }

}
