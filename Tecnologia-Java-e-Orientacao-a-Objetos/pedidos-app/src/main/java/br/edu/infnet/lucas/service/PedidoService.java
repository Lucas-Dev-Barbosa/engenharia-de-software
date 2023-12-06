package br.edu.infnet.lucas.service;

import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import br.edu.infnet.lucas.model.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService implements IPedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido getPedidoByCpfSolicitante(String cpf) throws PedidoException {
        return pedidoRepository.getById(cpf).orElseThrow(() -> new PedidoException("Pedido nao encontrado"));
    }

    @Override
    public Pedido insertPedido(Pedido pedido) {
        return pedidoRepository.insert(pedido);
    }

    @Override
    public void deletePedidoByCpfSolicitante(String cpf) {
        pedidoRepository.delete(cpf);
    }

    @Override
    public Pedido updatePedido(Pedido pedido) {
        return pedidoRepository.insert(pedido);
    }

    @Override
    public List<Pedido> listaPedidos() {
        return new ArrayList<>(pedidoRepository.getList());
    }
}
