package br.com.alura.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.modelo.Usuario;
import br.com.alura.repository.UsuarioRepository;

public class AutenticacaoTokenFilter extends OncePerRequestFilter{
	
	private TokenServices tokenServices;
	private UsuarioRepository repository;


	public AutenticacaoTokenFilter(TokenServices tokenServices, UsuarioRepository repository) {
		this.tokenServices = tokenServices;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenServices.isTokenValido(token);
		if (valido) {
			autenticarCliente(token);

		}
		
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {
		long idUsuario = tokenServices.getIdIsuario(token);
		Usuario usuario = repository.findById(idUsuario).get();;
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken
				(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
		return null;
	}
	
	return token.substring(7, token.length());

  }
	
}
