package br.edu.infnet.lucas.controller;

import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import br.edu.infnet.lucas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> listaPedidos() throws PedidoException {
        return pedidoService.listaPedidos();
    }

    @GetMapping("/{cpf}")
    public Pedido getPedidoByCpfSolicitante(@PathVariable String cpf) throws PedidoException {
        return pedidoService.getPedidoByCpfSolicitante(cpf);
    }

    @DeleteMapping("/{cpf}")
    public void deletePedidoByCpfSolicitante(@PathVariable String cpf) {
        pedidoService.deletePedidoByCpfSolicitante(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido insertPedido(@RequestBody Pedido pedido) {
        return pedidoService.insertPedido(pedido);
    }

    @PutMapping
    public Pedido updatePedido(@RequestBody Pedido pedido) {
        return pedidoService.updatePedido(pedido);
    }

}
