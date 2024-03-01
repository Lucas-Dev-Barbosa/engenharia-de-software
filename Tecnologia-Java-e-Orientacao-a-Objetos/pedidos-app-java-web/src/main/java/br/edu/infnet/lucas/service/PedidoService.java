package br.edu.infnet.lucas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import br.edu.infnet.lucas.model.domain.repository.PedidoRepository;

@Service
public class PedidoService implements IPedidoService {

	@Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido getPedidoById(Long id) throws PedidoException {
        return pedidoRepository.findById(id).orElseThrow(() -> new PedidoException("Pedido nao encontrado"));
    }

    @Override
    public Pedido insertPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deletePedidoById(Long id) {
    	Pedido pedido = pedidoRepository.findById(id).get();
        pedidoRepository.delete(pedido);
    }

    @Override
    public Pedido updatePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listaPedidos() {
        return new ArrayList<>(pedidoRepository.findAll());
    }
}
