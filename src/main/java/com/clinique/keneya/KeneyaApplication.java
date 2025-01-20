package com.clinique.keneya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.clinique.keneya.dao.RoleDao;
import com.clinique.keneya.dao.UserDao;
import com.clinique.keneya.entity.Role;
import com.clinique.keneya.entity.AppUser;
import com.clinique.keneya.service.ServiceAccount;

@SpringBootApplication
public class KeneyaApplication implements CommandLineRunner {
	
 @Autowired
 UserDao appUserRepository;
 @Autowired
 ServiceAccount accountService;
 @Autowired
 RoleDao roleDao;
 @Autowired(required=true)
 BCryptPasswordEncoder bCryptPasswordEncoder;
 @Bean
 public BCryptPasswordEncoder bCryptPasswordEncoder() {
	 return new BCryptPasswordEncoder();
 }
	public static void main(String[] args) {
		SpringApplication.run(KeneyaApplication.class, args);
	}

	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }


	public void createRole() {
		if (!roleDao.existsByRole("USER")) {
			accountService.saveRole(new Role(null, "USER"));
		}
		if (!roleDao.existsByRole("ADMIN")) {
			accountService.saveRole(new Role(null, "ADMIN"));
		}
		if (!roleDao.existsByRole("DEV")) {
			accountService.saveRole(new Role(null, "DEV"));
		}
		if (!roleDao.existsByRole("MEDECIN")) {
			accountService.saveRole(new Role(null, "MEDECIN"));
		}
		if (!roleDao.existsByRole("INFIRMIER")) {
			accountService.saveRole(new Role(null, "INFIRMIER"));
		}
		if (!roleDao.existsByRole("COMPTABLE")) {
			accountService.saveRole(new Role(null, "COMPTABLE"));
		}
	}
	
	public void createUser() {
		String username="medecin@ekeneya.ml";
		String password="Mali@12LM";
		String role1="USER";
		String role2="MEDECIN";

		if(!appUserRepository.existsByUsername(username)) {
			AppUser appUser=new AppUser();
			appUser.setUsername(username);
			appUser.setPassword(password);
			appUser=accountService.saveUser(appUser);
			appUser=accountService.addRoleToUser(username, role1);
			appUser=accountService.addRoleToUser(username, role2); 
		}

		String username1="admin1@ekeneya.ml";
		String password1="Mali@12LM";
		String role3="ADMIN";

		if(!appUserRepository.existsByUsername(username1)) {
			AppUser appUser=new AppUser();
			appUser.setUsername(username1);
			appUser.setPassword(password1);
			appUser=accountService.saveUser(appUser);
			appUser=accountService.addRoleToUser(username1, role3);
		}

		}

	@Override
	public void run(String... args) throws Exception {
		createRole();
		createUser();
	}

}
