package br.edu.infnet.lucas.model.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    
    private String descricao;
    private LocalDateTime data;
    private boolean web;

    private Solicitante solicitante;
    private List<Produto> listaProdutos;

}
