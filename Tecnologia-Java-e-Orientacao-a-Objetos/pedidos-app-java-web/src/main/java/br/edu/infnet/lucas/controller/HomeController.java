package br.edu.infnet.lucas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import br.edu.infnet.lucas.service.FileService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
    private FileService fileService;

    @GetMapping
    public ModelAndView home(ModelAndView modelAndView) throws PedidoException {
    	modelAndView.addObject("labels", fileService.leDadosArquivo());
    	modelAndView.setViewName("home");
        return modelAndView;
    }

}
