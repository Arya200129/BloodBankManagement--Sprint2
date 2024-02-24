package com.bloodbank.sbbm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.sbbm.service.AdminLoginService;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import jakarta.servlet.ServletException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminLoginController {
	
	@Autowired
	AdminLoginService las;
	
	@GetMapping("/adminlogin/{adminEmail}/{adminPassword}")
	public ResponseEntity<String> adminLogin(@PathVariable String adminEmail, @PathVariable String adminPassword){
		return ResponseEntity.ok(las.loginAdmin(adminEmail, adminPassword));
	}
	
	
//	@PostMapping("/Loogin")
//	public String validate(@RequestBody Login user)  throws ServletException{
//		String jwtToken ="";
//		if(user.getUserName() == null || user.getPassword() == null) {
//			throw new ServletException("Mandotory to fill username & password");
//		}
//		
//		String username =user.getUserName();
//		String password = user.getPassword();
//		user = ls.loginCustomer(username, password);
//		
//		if(user == null) {
//			throw new ServletException("user details not found");
//		}
//		
//		jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
//				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();				
//				
//		return jwtToken;
//	}

}
