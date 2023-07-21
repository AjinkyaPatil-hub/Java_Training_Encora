package com.encora.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.encora.service.serviceImpl.CustomUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsServiceImpl customUserDetailsService;

	@Autowired
	private JwtAutheticationFilter jwFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 *  1: csrf disable to prevent attack 
		 *  2:/token all public to any user access 
		 *  3: then add authenticate to any other request other than token
		 *  4: make session creation as state-less because it is client server creation
		 *  5: validate token by jwtFilter
		 */  
		http
			.csrf()
			.disable()
			.cors()
			.disable()
			.authorizeHttpRequests()
			.antMatchers("/token","/register").permitAll()
			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	 http.addFilterBefore(jwFilter, UsernamePasswordAuthenticationFilter.class);	
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	@Bean
	   public BCryptPasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	   }
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
