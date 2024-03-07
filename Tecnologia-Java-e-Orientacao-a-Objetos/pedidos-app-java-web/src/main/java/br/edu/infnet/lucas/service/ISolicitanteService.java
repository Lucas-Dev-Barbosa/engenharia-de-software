package br.edu.infnet.lucas.service;

import java.util.List;

import br.edu.infnet.lucas.model.domain.Solicitante;

public interface ISolicitanteService {
	
	Solicitante getSolicitanteById(Long id);

	Solicitante insertSolicitante(Solicitante solicitante);

    void deleteSolicitanteById(Long id);

    Solicitante updateSolicitante(Solicitante solicitante);

    List<Solicitante> listaSolicitante();

}
