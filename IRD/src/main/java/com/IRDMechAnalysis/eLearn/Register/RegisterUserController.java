package com.IRDMechAnalysis.eLearn.Register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class RegisterUserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/register")
	public void register(@RequestBody UserInfo ud) {
       userservice.saveUser(ud);  	
	}
	
	@GetMapping("/allUsers")
	public List<UserInfo> ViewUsers() {
		return userservice.allUser();
	}

}
