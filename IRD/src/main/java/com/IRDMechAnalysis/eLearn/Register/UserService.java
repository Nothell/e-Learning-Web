package com.IRDMechAnalysis.eLearn.Register;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class UserService {

	@Autowired
	private UserRepository userrepository;

	public List<UserInfo> allUser() {
		List<UserInfo> alluser = new ArrayList<>();
		userrepository.findAll().forEach(alluser::add);
		return alluser;

	}

	public void saveUser(UserInfo ur) {
		userrepository.save(ur);
	}

}
