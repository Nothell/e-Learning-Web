package com.IRDMechAnalysis.eLearn.Login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.IRDMechAnalysis.eLearn.Register.UserInfo;
import com.IRDMechAnalysis.eLearn.Register.UserRepository;

@Service
public class LoginService {
	@Autowired
	private UserRepository ur;

	public String Validate(UserInfo ui) {
		String check = "notValid";
		List<UserInfo> l = ur.findByName(ui.getName());
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getName().equals(ui.getName()) && BCrypt.checkpw(ui.getPassword(), l.get(i).getPassword())) {
				check = "WELCOME "+ ui.getName();
				break;
			}
		}
		return check;
	}

}
