package com.clinique.keneya.service;




import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.RoleDao;
import com.clinique.keneya.dao.UserDao;
import com.clinique.keneya.entity.Role;
import com.clinique.keneya.entity.AppUser;




@Service
@Transactional
public class ServiceAccount{
	
	private UserDao appUserRepository;
	private RoleDao appRoleRepository;
	@Autowired(required = true)
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public ServiceAccount(UserDao appUserRepository, RoleDao appRoleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.appUserRepository = appUserRepository;
		this.appRoleRepository = appRoleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	public AppUser saveUser(AppUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return appUserRepository.save(user); 
	}
	public Role saveRole(Role appRole) { 
		return appRoleRepository.save(appRole); 
	}
	
	public AppUser findUserByUsername(String username) { 
		return appUserRepository.findByUsername(username);
	} 
	
	public AppUser addRoleToUser(String username, String roleName) { 
		AppUser appUser = appUserRepository.findByUsername(username);
		Role appRole = appRoleRepository.findByRole(roleName);
		appUser.getRoles().add(appRole); 
		return appUserRepository.save(appUser);
	}
	
	
 
	public AppUser findUserById(Long idUser) {
		return appUserRepository.getOne(idUser); 
	} 

	public AppUser saveOwner(AppUser owner) {
		owner.setPassword(bCryptPasswordEncoder.encode(owner.getPassword()));
		return appUserRepository.save(owner); 		
	}
	
	    
}