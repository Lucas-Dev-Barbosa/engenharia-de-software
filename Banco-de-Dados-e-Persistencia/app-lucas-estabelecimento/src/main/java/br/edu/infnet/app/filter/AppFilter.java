package br.edu.infnet.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.infnet.app.model.domain.Usuario;
import br.edu.infnet.app.model.service.UsuarioService;

@Component
public class AppFilter implements Filter {

	@Autowired
	private UsuarioService service;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String login = null;
		String senha = null;

		String uri = req.getRequestURI();

		if ("/usuarios/validar".equals(uri)) {
			login = request.getParameter("login");
			senha = request.getParameter("senha");

			Usuario usuario = service.validar(login, senha);
			if (usuario != null) {
				req.getSession().setAttribute("login", usuario.getLogin());
				resp.sendRedirect("/");
				return;
			}

			resp.sendRedirect("/login");
			return;
		} if("/login".equals(uri)) {
			chain.doFilter(request, response);
			return;
		} if("/logout".equals(uri)) {
			req.getSession().removeAttribute("login");
			resp.sendRedirect("/login");
			return;
		} else {
			if (req.getSession().getAttribute("login") == null) {
				resp.sendRedirect("/login");
				return;
			}
			
			chain.doFilter(request, response);
			return;
		}

	}

}
