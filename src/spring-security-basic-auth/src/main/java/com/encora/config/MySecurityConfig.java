package com.encora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//		.antMatchers("/api/v1/public/**").permitAll()
//		.antMatchers("/api/v1/user/**").hasRole("USER")
//		.antMatchers("/api/v1/**").hasRole("ADMIN")
		.anyRequest().authenticated().and()
				.httpBasic();
	}*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("1234")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password(this.passwordEncoder().encode("1234")).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
