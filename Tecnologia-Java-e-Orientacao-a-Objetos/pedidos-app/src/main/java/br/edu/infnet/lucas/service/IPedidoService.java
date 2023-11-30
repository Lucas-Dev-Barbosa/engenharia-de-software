package br.edu.infnet.lucas.service;

import br.edu.infnet.lucas.model.domain.Pedido;

public interface IPedidoService {

    Pedido getPedidoByCpfSolicitante(String cpf);

    void insertPedido(Pedido pedido);

    void deletePedidoByCpfSolicitante(String cpf);

    void updatePedido(Pedido pedido);

}
