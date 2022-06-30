package br.edu.infnet.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.app.model.domain.Usuario;

@FeignClient(url = EstabelecimentoApi.URL, path = EstabelecimentoApi.PATH_USUARIO, name = EstabelecimentoApi.USUARIO_NAME_CLIENT)
public interface UsuarioClient {
	
	@PostMapping(value = "/validar")
	public Usuario validar(@RequestParam String login, @RequestParam String senha);

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);

	@GetMapping(value = "/listar")
	public List<Usuario> obterLista();

}
