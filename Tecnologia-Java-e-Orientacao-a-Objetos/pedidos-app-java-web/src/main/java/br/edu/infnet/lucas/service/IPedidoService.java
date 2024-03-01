package br.edu.infnet.lucas.service;

import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;

import java.util.List;

public interface IPedidoService {

    Pedido getPedidoById(Long id) throws PedidoException;

    Pedido insertPedido(Pedido pedido);

    void deletePedidoById(Long id);

    Pedido updatePedido(Pedido pedido);

    List<Pedido> listaPedidos();
}
