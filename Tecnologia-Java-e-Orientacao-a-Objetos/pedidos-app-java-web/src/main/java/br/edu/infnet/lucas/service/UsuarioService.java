package br.edu.infnet.lucas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.lucas.model.domain.Usuario;
import br.edu.infnet.lucas.model.domain.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Override
    public List<Usuario> listaUsuario() {
        return new ArrayList<>(usuarioRepository.findAll());
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(new Usuario());
    }

    @Override
    public Usuario insertUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuarioById(Long id) {
    	Usuario Usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(Usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
