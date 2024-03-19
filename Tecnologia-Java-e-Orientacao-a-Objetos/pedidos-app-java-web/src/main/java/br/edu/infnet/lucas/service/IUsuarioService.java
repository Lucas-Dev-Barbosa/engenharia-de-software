package br.edu.infnet.lucas.service;

import java.util.List;

import br.edu.infnet.lucas.model.domain.Usuario;

public interface IUsuarioService {
	
	Usuario getUsuarioById(Long id);

	Usuario insertUsuario(Usuario usuario);

    void deleteUsuarioById(Long id);

    Usuario updateUsuario(Usuario usuario);

    List<Usuario> listaUsuario();

}
