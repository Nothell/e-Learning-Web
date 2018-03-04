package com.IRDMechAnalysis.eLearn.Register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IRDMechAnalysis.eLearn.WebSecurityConfig;

@RestController
@ComponentScan
public class RegisterUserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private WebSecurityConfig webSec;
	
	@PostMapping("/register")
	public void register(@RequestBody UserInfo ud) {
	   String pass=webSec.Encrypt(ud.getPassword());
	   ud.setPassword(pass);
       userservice.saveUser(ud);  	
	}
	
	@GetMapping("/allUsers")
	public List<UserInfo> ViewUsers() {
		return userservice.allUser();
	}

}
