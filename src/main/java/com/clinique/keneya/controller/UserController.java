package com.clinique.keneya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinique.keneya.entity.AppUser;
import com.clinique.keneya.service.ServiceAccount;
import com.clinique.keneya.service.ServiceUser;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private ServiceUser serviceUser;
	
	@Autowired
	private ServiceAccount serviceAccount;
	
	@GetMapping("/all")
	private List<AppUser>getArrayList(){
		return this.serviceUser.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<AppUser>getUserById(@PathVariable Long id){
		AppUser user = serviceUser.findById(id);
		return ResponseEntity.ok(user);
	}
	@PostMapping("/nouveau")
	public void createUser(@RequestBody AppUser user){
		AppUser nouveauUser = serviceUser.save(user);
		
	}
	
	@PostMapping("/nouveauEmploye")
	public ResponseEntity<AppUser> createEmploye(@RequestBody AppUser user,@RequestParam String role){
		AppUser nouveauUser = serviceAccount.saveUser(user);
		serviceAccount.addRoleToUser(user.getUsername(), role);
		return new ResponseEntity<>(nouveauUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AppUser>updateUser(@PathVariable Long id, @RequestBody AppUser user){
		AppUser userMisAJour = serviceUser.update(id,user,id);
		return ResponseEntity.ok(userMisAJour);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		this.serviceUser.delete(id);
	}
	

}
