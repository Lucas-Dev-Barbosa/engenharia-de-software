package br.edu.infnet.lucas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import br.edu.infnet.lucas.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ModelAndView listaPedidos(ModelAndView modelAndView) throws PedidoException {
    	modelAndView.addObject("pedidos", pedidoService.listaPedidos());
    	modelAndView.setViewName("pedidos/list-pedidos");
        return modelAndView;
    }

    @GetMapping("/{id-pedido}")
    public Pedido getPedidoById(@PathVariable(name = "id-pedido") Long id) throws PedidoException {
        return pedidoService.getPedidoById(id);
    }

    @GetMapping("/delete/{id-pedido}")
    public void deletePedidoById(@PathVariable(name = "id-pedido") Long id) {
        pedidoService.deletePedidoById(id);
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
