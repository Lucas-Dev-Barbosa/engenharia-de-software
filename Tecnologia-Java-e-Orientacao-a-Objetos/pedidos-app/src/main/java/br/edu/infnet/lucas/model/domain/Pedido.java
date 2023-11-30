package br.edu.infnet.lucas.model.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido extends AbstractEntity {
    
    private String descricao;
    private LocalDateTime data;
    private boolean web;

    private Solicitante solicitante;
    private List<Produto> listaProdutos;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
        this.setId(solicitante.getCpf());
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
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
