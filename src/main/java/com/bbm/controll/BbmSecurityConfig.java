package com.bbm.controll;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebSecurity(debug = true)
public class BbmSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
		http.authorizeHttpRequests()
		//.requestMatchers("/**").permitAll()
		 .requestMatchers("/welcome/**").permitAll()
		 .requestMatchers("/welcomeProcedure/**").permitAll()
		 .requestMatchers("/specimen/**").authenticated()
		 .requestMatchers("/procedure/**").authenticated()
		 .requestMatchers("/deletespecimen/**").authenticated()
		 .requestMatchers("/deleteprocedure/**").authenticated()
		 .requestMatchers("/v2/api-docs",
					"/v3/api-docs/**",
					"/swagger-resources/configuration/ui",  
					"/swagger-resources/configuration/security", 
					"/webjars/**",
					"/swagger-ui.html","/swagger-ui/**").permitAll();
		http.httpBasic();
		http.cors();
		http.csrf().disable(); // 403forbidden error
		return http.build();
		
	}
}
