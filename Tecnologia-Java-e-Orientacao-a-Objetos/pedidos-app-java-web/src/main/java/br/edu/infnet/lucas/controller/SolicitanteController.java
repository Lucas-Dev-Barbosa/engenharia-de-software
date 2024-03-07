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

import br.edu.infnet.lucas.model.domain.Solicitante;
import br.edu.infnet.lucas.service.ISolicitanteService;

@Controller
@RequestMapping("/solicitantes")
public class SolicitanteController {

	@Autowired
    private ISolicitanteService solicitanteService;

    @GetMapping("/lista")
    public ModelAndView listaSolicitantes(ModelAndView modelAndView) {
    	modelAndView.addObject("solicitantes", solicitanteService.listaSolicitante());
    	modelAndView.setViewName("solicitantes/list-solicitantes");
        return modelAndView;
    }
    
    @GetMapping("/new")
    public String solicitante(Model model) {
    	return "solicitantes/solicitante";
    }
    
    @PostMapping("/salva")
    public String insertSolicitantes(Solicitante solicitante) {
        solicitanteService.insertSolicitante(solicitante);
        return "redirect:/solicitantes/lista";
    }

    @GetMapping("/solicitante/{idSolicitante}")
    public String getSolicitanteById(@PathVariable(name = "idSolicitante") Long id, Model model) {
    	model.addAttribute("solicitante", solicitanteService.getSolicitanteById(id));
    	return "solicitantes/solicitante"; 
    }

    @GetMapping("/{idSolicitante}/delete")
    public String deleteSolicitanteById(@PathVariable(name = "idSolicitante") Long id) {
        solicitanteService.deleteSolicitanteById(id);
        return "redirect:/solicitantes/lista";
    }

    @PutMapping
    public Solicitante updateSolicitante(@RequestBody Solicitante solicitante) {
        return solicitanteService.updateSolicitante(solicitante);
    }

}
