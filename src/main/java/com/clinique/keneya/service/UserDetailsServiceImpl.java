package com.clinique.keneya.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clinique.keneya.entity.AppUser;

@Service 
public class UserDetailsServiceImpl implements UserDetailsService { 

	@Autowired
	private ServiceAccount accountService; 
	 
	public UserDetailsServiceImpl( ServiceAccount accountService) {
		this.accountService = accountService;
	}
	
	@Override 
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException { 
		AppUser appUser=accountService.findUserByUsername(username);
		if(appUser==null) 
			throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		appUser.getRoles().forEach(role->{
			authorities.add(new SimpleGrantedAuthority(role.getRole())); 
			}); 
		return new User(appUser.getUsername(), appUser.getPassword(), authorities); 
	} 
	
	
}
