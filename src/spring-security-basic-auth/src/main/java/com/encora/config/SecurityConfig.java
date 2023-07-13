//package com.encora.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.stereotype.Component;
//
////@Configuration
//@EnableWebSecurity
//@Component
////@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfig {
//
//	@Bean
//	public UserDetailsService authenticateUser(PasswordEncoder passwordEncoder) {
//		UserDetails adminUserDetails = User.withUsername("admin").password(passwordEncoder.encode("1234")).build();
//		UserDetails userDetails = User.withUsername("admin").password(passwordEncoder.encode("1234")).build();
//		return new InMemoryUserDetailsManager(adminUserDetails, userDetails);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	
//}
