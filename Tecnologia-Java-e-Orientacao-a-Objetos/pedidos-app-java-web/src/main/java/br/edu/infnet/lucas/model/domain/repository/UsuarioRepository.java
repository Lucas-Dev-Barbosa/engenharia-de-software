package br.edu.infnet.lucas.model.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.lucas.model.domain.Usuario;
import br.edu.infnet.lucas.model.domain.vos.Email;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(Email email);

}
