package br.edu.infnet.lucas.service;

import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido getPedidoByCpfSolicitante(String cpf) {
        return null;
    }

    @Override
    public void insertPedido(Pedido pedido) {

    }

    @Override
    public void deletePedidoByCpfSolicitante(String cpf) {

    }

    @Override
    public void updatePedido(Pedido pedido) {

    }

    @Override
    public List<Pedido> listaPedidos() {
        return new ArrayList<>(pedidoRepository.getList());
    }
}
