package br.edu.infnet.lucas.model.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido extends AbstractEntity {
    
    private String descricao;
    private LocalDateTime data;
    private boolean web;

    private Solicitante solicitante;
    private List<Produto> listaProdutos;

    public Pedido(String descricao, LocalDateTime data, boolean web, Solicitante solicitante, List<Produto> listaProdutos) {
        this.descricao = descricao;
        this.data = data;
        this.web = web;

        this.solicitante = solicitante;
        this.listaProdutos = listaProdutos;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() {
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
