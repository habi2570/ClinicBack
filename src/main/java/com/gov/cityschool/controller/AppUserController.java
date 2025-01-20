package com.gov.cityschool.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinique.keneya.dao.UserDao;
import com.clinique.keneya.entity.AppUser;
import com.clinique.keneya.service.ServiceAccount;

@RestController
@RequestMapping("/account")
public class AppUserController {
	
	
	@Autowired
	private ServiceAccount accountService;
	
	@Autowired
	private UserDao  appUserRepository;
		
	@GetMapping("/all")
	public List<AppUser> findAll(){
		return appUserRepository.findAll();
	}
	@GetMapping("/all/delete")
	public void deleteAll(){
		appUserRepository.deleteAll();
	}
	@PostMapping("/user")
	public ResponseEntity<Object> signUpUser(@RequestBody AppUser user, @RequestParam String role) {
		Map<String, String> message = new HashMap();
		String username = user.getUsername();
			// AppUser user=accountService.findUserByUsername(username);
			String password = user.getPassword();
			user.setPassword(password);
			user.setUsername(username);

			user=accountService.saveUser(user);
			user=accountService.addRoleToUser(username, role);
			user=accountService.addRoleToUser(username, "USER");

		
			//emailSenderService.sendEmail(mailMessage);

			return new ResponseEntity<Object>(user, HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/id/{username}")
	public Long getUserId(@PathVariable("username") String username) {
		AppUser user = this.accountService.findUserByUsername(username);
		if (user != null) {
			return user.getId();
		} else {
			return null;
		}
	}

	@GetMapping("/role")
	public boolean isUser() {
		return true;
	}

	// Reset password:
	@PostMapping(value = "/forgotPassword/{userEmail}")
	public ResponseEntity<Object> processForgotPasswordForm(@PathVariable("userEmail") String userEmail,
			HttpServletRequest request) {
		
			// Lookup user in database by e-mail
			AppUser user = accountService.findUserByUsername(userEmail);

			
			// Save token to database
			accountService.saveUser(user);

			// Email message

			
			return new ResponseEntity<Object>(userEmail, HttpStatus.OK);

	}

	@GetMapping(value = "/reset/{token}")
	public ResponseEntity<Object> displayResetPasswordPage(@PathVariable("token") String token) {

		Map<String, String> message = new HashMap();

		
			return new ResponseEntity<Object>(token, HttpStatus.OK);

	}


	/*
	 * @PostMapping("/changePassword/{idUser}") public ResponseEntity<Object>
	 * changePasswordWithJWTToken(@PathVariable("idUser") Long idUser,
	 * 
	 * @RequestBody ResetPasswordForm data) { Map<String, String> message = new
	 * HashedMap(); System.out.println(data); try {
	 * appUserValidator.validatePassword(data.getPassword());
	 * appUserValidator.validatePasswordAndRepassword(data.getPassword(),
	 * data.getRepassword());
	 * 
	 * AppUser user = accountService.findUserById(idUser);
	 * 
	 * user.setPassword(data.getPassword()); accountService.saveUser(user);
	 * 
	 * // SimpleMailMessage mailMessage = new SimpleMailMessage(); //
	 * mailMessage.setTo(user.getUsername()); //
	 * mailMessage.setSubject("Password Reset Request"); //
	 * mailMessage.setFrom("cityskills.not.reply@gmail.com"); //
	 * mailMessage.setText(PASSWORD_RESETED_SUCCESSFULY); // //
	 * emailSenderService.sendEmail(mailMessage);
	 * 
	 * return new ResponseEntity<Object>(user, HttpStatus.OK);
	 * 
	 * } catch (PasswordSyntaxeException e) { message.put("message",
	 * e.getMessage()); } catch (PasswordDontEqualsToRepassword e) {
	 * message.put("message", e.getMessage()); } return new
	 * ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * }
	 */

}