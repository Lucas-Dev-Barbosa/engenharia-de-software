package br.edu.infnet.lucas.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Pedido extends AbstractEntity {

    private String descricao;

    private Date data;
    private boolean web;

    private Solicitante solicitante;
    private List<Produto> listaProdutos;

    public Pedido(@JsonProperty("descricao") String descricao,
                  @JsonProperty("data") @JsonFormat
                          (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss") Date data,
                  @JsonProperty("web") boolean web,
                  @JsonProperty("solicitante") Solicitante solicitante,
                  @JsonProperty("listaProdutos") List<Produto> listaProdutos) {
        this.descricao = descricao;
        this.data = data;
        this.web = web;

        this.solicitante = solicitante;
        this.listaProdutos = listaProdutos;

        this.setId(solicitante.getCpf().getCpf());
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public boolean isWeb() {
        return web;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "descricao='" + descricao + '\'' +
                ", data=" + data +
                ", web=" + web +
                ", solicitante=" + solicitante +
                ", listaProdutos=" + listaProdutos +
                '}';
    }
}
