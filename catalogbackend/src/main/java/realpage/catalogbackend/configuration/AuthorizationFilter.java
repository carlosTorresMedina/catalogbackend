/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realpage.catalogbackend.configuration;

import io.jsonwebtoken.ExpiredJwtException;
import realpage.catalogbackend.util.TokenUtils;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Filter used to validate the authorization.
 * 
 * @author carlos.torres
 */
@Component
public class AuthorizationFilter extends OncePerRequestFilter {


	private TokenUtils tokenUtils;

	@Autowired
	public AuthorizationFilter(TokenUtils tokenUtils) {
		this.tokenUtils = tokenUtils;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String requestHeader = request.getHeader("Authorization");

		String usuario = null;
		String authToken = null;

		if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
			authToken = requestHeader.substring(7);
			try {
				usuario = tokenUtils.getUsernameFromToken(authToken);
			} catch (IllegalArgumentException e) {
				logger.error("There is an error getting the username of the token.",
						e);
			} catch (ExpiredJwtException e) {
				logger.warn("The token is expired.",
						e);
			} catch (Exception e) {
				logger.warn("Error in the token structure.", e);
			}
		} else {
			logger.warn("No found the String, header ignored.");
		}

		if (usuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			logger.debug("The security context was null, the user is authorized.");

			if (tokenUtils.validateToken(authToken, usuario)) {
					final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, new ArrayList<>());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					logger.info("User authorized"+usuario+", configuring the security context.");
					SecurityContextHolder.getContext().setAuthentication(authentication);
			} else {
				logger.warn("the token is not valid.");
			}
		}
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

		filterChain.doFilter(request, response);

	}
	
}
