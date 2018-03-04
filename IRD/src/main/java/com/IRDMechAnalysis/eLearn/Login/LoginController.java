package com.IRDMechAnalysis.eLearn.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IRDMechAnalysis.eLearn.Register.UserInfo;

@RestController
public final class LoginController {

    @Autowired
	private LoginService loginservice;
	
	@PostMapping("/login")
	public String Validate(@RequestBody UserInfo ui) { 
		String check=loginservice.Validate(ui);
		return check;
	}
}
