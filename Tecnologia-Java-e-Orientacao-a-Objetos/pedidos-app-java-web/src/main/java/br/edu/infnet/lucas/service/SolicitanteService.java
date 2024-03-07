package br.edu.infnet.lucas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.lucas.model.domain.Solicitante;
import br.edu.infnet.lucas.model.domain.repository.SolicitanteRepository;

@Service
public class SolicitanteService implements ISolicitanteService {

	@Autowired
    private SolicitanteRepository solicitanteRepository;
	
	@Override
    public List<Solicitante> listaSolicitante() {
        return new ArrayList<>(solicitanteRepository.findAll());
    }

    @Override
    public Solicitante getSolicitanteById(Long id) {
        return solicitanteRepository.findById(id).orElse(new Solicitante());
    }

    @Override
    public Solicitante insertSolicitante(Solicitante solicitante) {
        return solicitanteRepository.save(solicitante);
    }

    @Override
    public void deleteSolicitanteById(Long id) {
    	Solicitante solicitante = solicitanteRepository.findById(id).get();
        solicitanteRepository.delete(solicitante);
    }

    @Override
    public Solicitante updateSolicitante(Solicitante solicitante) {
        return solicitanteRepository.save(solicitante);
    }

}
