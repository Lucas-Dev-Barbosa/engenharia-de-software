package br.edu.infnet.lucas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/lista")
    public ModelAndView listaPedidos(ModelAndView modelAndView) {
    	modelAndView.addObject("pedidos", pedidoService.listaPedidos());
    	modelAndView.setViewName("pedidos/list-pedidos");
        return modelAndView;
    }
    
    @GetMapping("/new")
    public String pedido(Model model) {
    	return "pedidos/pedido";
    }
    
    @PostMapping("/salva")
    @ResponseStatus(HttpStatus.CREATED)
    public String insertPedido(@RequestBody Pedido pedido) {
        pedidoService.insertPedido(pedido);
        return "redirect:/pedidos/lista";
    }

    @GetMapping("/pedido/{idPedido}")
    public String getPedidoById(@PathVariable(name = "idPedido") Long id, Model model) throws PedidoException {
    	model.addAttribute("pedido", pedidoService.getPedidoById(id));
    	return "pedidos/pedido"; 
    }

    @GetMapping("/delete/{id-pedido}")
    public String deletePedidoById(@PathVariable(name = "id-pedido") Long id) {
        pedidoService.deletePedidoById(id);
        return "redirect:/pedidos/lista";
    }

    @PutMapping
    public Pedido updatePedido(@RequestBody Pedido pedido) {
        return pedidoService.updatePedido(pedido);
    }

}
