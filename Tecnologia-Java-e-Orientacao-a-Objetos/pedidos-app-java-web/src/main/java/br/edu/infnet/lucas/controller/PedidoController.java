package br.edu.infnet.lucas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import br.edu.infnet.lucas.service.IPedidoService;
import br.edu.infnet.lucas.service.ISolicitanteService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
    private IPedidoService pedidoService;
	
	@Autowired
    private ISolicitanteService solicitanteService;

    @GetMapping("/lista")
    public ModelAndView listaPedidos(ModelAndView modelAndView) {
    	modelAndView.addObject("pedidos", pedidoService.listaPedidos());
    	modelAndView.setViewName("pedidos/list-pedidos");
        return modelAndView;
    }
    
    @GetMapping("/new")
    public String pedido(Model model) {
    	model.addAttribute("solicitantes", solicitanteService.listaSolicitante());
    	return "pedidos/pedido";
    }
    
    @PostMapping("/salva")
    public String insertPedido(Pedido pedido) {
        pedidoService.insertPedido(pedido);
        return "redirect:/pedidos/lista";
    }

    @GetMapping("/pedido/{idPedido}")
    public String getPedidoById(@PathVariable(name = "idPedido") Long id, Model model) throws PedidoException {
    	model.addAttribute("pedido", pedidoService.getPedidoById(id));
    	return "pedidos/pedido"; 
    }

    @GetMapping("/{idPedido}/delete")
    public String deletePedidoById(@PathVariable(name = "idPedido") Long id) {
        pedidoService.deletePedidoById(id);
        return "redirect:/pedidos/lista";
    }

    @PutMapping
    public Pedido updatePedido(@RequestBody Pedido pedido) {
        return pedidoService.updatePedido(pedido);
    }

}
