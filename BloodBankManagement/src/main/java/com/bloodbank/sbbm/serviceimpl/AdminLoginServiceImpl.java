package com.bloodbank.sbbm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.sbbm.entity.AdminLogin;
import com.bloodbank.sbbm.repository.AdminLoginRepository;
import com.bloodbank.sbbm.service.AdminLoginService;

@Service
public class AdminLoginServiceImpl  implements AdminLoginService{

	@Autowired
	AdminLoginRepository alrepo;
	
	@Override
	public String loginAdmin(String adminEmail, String adminPassword) {
		AdminLogin adminLogin = alrepo.findByEmail(adminEmail);
		
		if(adminLogin!=null) {
			if(adminLogin.getAdminPassword().equals(adminPassword))
				return "You are Welcome";
			return "Invalid password";
		}
		else
			return "Invalid Admin email";
	}

}
