/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realpage.catalogbackend.configuration;

import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Class used to configure spring security json web tokens
 * @author carlos.torres
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String urlAuthentication = "/auth";

	private final AuthenticationFilter authenticationFilter;

	private final AuthorizationFilter authorizationFilter;

	@Autowired
	public WebSecurityConfiguration(AuthenticationFilter authenticationFilter,
			AuthorizationFilter authorizationFilter) {
		this.authenticationFilter = authenticationFilter;
		this.authorizationFilter = authorizationFilter;
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint(authenticationFilter).and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, urlAuthentication).permitAll().antMatchers(HttpMethod.GET, "**")
				.permitAll().anyRequest().authenticated().and().cors()
				.configurationSource((HttpServletRequest request) -> {
					CorsConfiguration config = new CorsConfiguration();
					config.setAllowedHeaders(Collections.singletonList("*"));
					config.setAllowedMethods(Collections.singletonList("*"));
					config.addAllowedOrigin("*");
					config.setAllowCredentials(true);
					return config;
				});

	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

}
