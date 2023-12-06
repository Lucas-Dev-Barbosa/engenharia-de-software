package br.edu.infnet.lucas.service;

import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;

import java.util.List;

public interface IPedidoService {

    Pedido getPedidoByCpfSolicitante(String cpf) throws PedidoException;

    Pedido insertPedido(Pedido pedido);

    void deletePedidoByCpfSolicitante(String cpf);

    Pedido updatePedido(Pedido pedido);

    List<Pedido> listaPedidos();
}
