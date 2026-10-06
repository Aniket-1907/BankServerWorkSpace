package com.cg.bankserver.authenticationservice.config;

import com.cg.bankserver.authenticationservice.security.JWTAuthenticationFilter;
import com.cg.bankserver.authenticationservice.security.JWTVerifierFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cg.bankserver.authenticationservice.security.ApplicationUserDetailsService;
import com.cg.bankserver.authenticationservice.services.TokensRedisService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private ApplicationUserDetailsService applicationUserDetailsService;

	@Autowired
	private TokensRedisService redisService;

	@Autowired
	@Lazy
	private AuthenticationManager authenticationManager;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
			http.csrf().disable();
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.addFilter(new JWTAuthenticationFilter(authenticationManager, redisService));
			http.addFilterAfter(new JWTVerifierFilter(redisService), JWTAuthenticationFilter.class).authorizeHttpRequests();
			http.authorizeHttpRequests((auth) -> auth.requestMatchers("/add").permitAll());
			http.authorizeHttpRequests((auth) -> auth.requestMatchers("/actuator/**").permitAll());
	        http.authorizeHttpRequests((auth)->auth.
							anyRequest().authenticated());
	        return http.build();
	}
}