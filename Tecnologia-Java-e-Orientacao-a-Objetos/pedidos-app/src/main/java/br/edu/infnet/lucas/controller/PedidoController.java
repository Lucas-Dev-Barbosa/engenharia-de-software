package br.edu.infnet.lucas.controller;

import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> teste() {
        return pedidoService.listaPedidos();
    }
}
