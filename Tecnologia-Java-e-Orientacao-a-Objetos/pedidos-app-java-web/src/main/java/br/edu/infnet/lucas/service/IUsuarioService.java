package br.edu.infnet.lucas.service;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.lucas.model.domain.Usuario;
import br.edu.infnet.lucas.model.domain.vos.Email;

public interface IUsuarioService {
	
	Usuario getUsuarioById(Long id);
	
	Optional<Usuario> getUsuarioByEmail(Email email);

	Usuario insertUsuario(Usuario usuario);

    void deleteUsuarioById(Long id);

    Usuario updateUsuario(Usuario usuario);

    List<Usuario> listaUsuario();

}
