package br.com.bookstock.model.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bookstock.model.domain.LivroFisico;

@Repository
public interface LivroFisicoRepository extends JpaRepository<LivroFisico, Long> {
	
}
