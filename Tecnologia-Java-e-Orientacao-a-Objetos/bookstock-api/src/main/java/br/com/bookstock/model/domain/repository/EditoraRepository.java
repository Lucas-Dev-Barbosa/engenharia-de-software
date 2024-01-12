package br.com.bookstock.model.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bookstock.model.domain.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{

}
