package com.clinique.keneya.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; 
@Configuration 
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired private UserDetailsService userDetailsService; 
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder; 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder); 
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.csrf().disable() // don't create session 
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
		.and()
		.authorizeRequests() 
		.antMatchers("/account/all/**","login/**","/login/**", "/account/forgotPassword/**","/account/reset/**","/account/resetPassword/**") 
		.permitAll() 
		.antMatchers("/Diagnostic/**","/Patient/nouveau","/Patient/**", "/account/profil/**")
		.hasAuthority("MEDECIN")
		.antMatchers("/User/**","/administrateur/**").hasAuthority("ADMIN")
		.antMatchers("/roles/JUSTICE").hasAuthority("JUSTICE")
		.antMatchers("/roles/DEV").hasAuthority("DEV")
		.antMatchers().hasAuthority("DEV")
		.antMatchers("/v2/api-docs/**","/acteNaissance/findAll").hasAuthority("DEV")
		.antMatchers("/roles/ADMIN","/account/user/**").hasAuthority("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class); 

	}
}