package br.edu.infnet.lucas.model.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.lucas.model.domain.Solicitante;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Long>{

}
