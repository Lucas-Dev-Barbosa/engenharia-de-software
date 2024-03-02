package br.edu.infnet.lucas.service;

import java.util.List;

import br.edu.infnet.lucas.model.domain.Pedido;

public interface IPedidoService {

    Pedido getPedidoById(Long id);

    Pedido insertPedido(Pedido pedido);

    void deletePedidoById(Long id);

    Pedido updatePedido(Pedido pedido);

    List<Pedido> listaPedidos();
}
