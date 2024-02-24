package com.bloodbank.sbbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.sbbm.entity.BloodUser;
import com.bloodbank.sbbm.service.BloodUserService;

import jakarta.validation.Valid;

//handling all incoming request for entity patient
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BloodUserController {

	@Autowired
	BloodUserService us;
	
	//using post mapping to add BloodUser details with httpstatus created
	//valid - will check all validation of BloodUser entity during runtime
	//requestBody - indicates method parameter should be bound to the body of the web request
	@PostMapping("/registerBloodUser")
	public ResponseEntity<BloodUser> saveBloodUser(@Valid@RequestBody BloodUser bloodUser){
		
		return new ResponseEntity<BloodUser>(us.registerBloodUser(bloodUser), HttpStatus.CREATED);
	}
	
	//using GetMapping to fetch BloodUser based on id with httpstatus Ok
	//path Variable - indicates that a method parameter should be bound to uri template variable
	@GetMapping("/getBloodUserDetails/{userId}")
	public ResponseEntity<BloodUser> fetchBloodUser(@PathVariable("userId") int userId){
		
		return new ResponseEntity<BloodUser>(us.fetchBloodUser(userId), HttpStatus.OK);
	}
	
	//using DeleteMapping to remove BloodUser based on id with httpstatus Ok
	@DeleteMapping("/deleteBloodUser/{userId}")
	public ResponseEntity<String> deleteBloodUser(@PathVariable("userId") int userId){
		
		us.deleteBloodUser(userId);
		return new ResponseEntity<String>("BloodUser record deleted successfully!",  HttpStatus.OK);
	}
	
	//using PutMapping to edit BloodUser details based on id with httpstatus Ok
	@PutMapping("/editBloodUser/{userId}")
	public ResponseEntity<BloodUser> editBloodUser(@Valid@PathVariable("userId") int userId, @RequestBody BloodUser bloodUser){
		
		return new ResponseEntity<BloodUser>(us.editBloodUser(bloodUser, userId), HttpStatus.OK);
	}
	
	@GetMapping("/login/{userEmail}/{password}")
	public ResponseEntity<Integer> login(@PathVariable String userEmail, @PathVariable String password){
		return new ResponseEntity<Integer>(us.login(userEmail, password), HttpStatus.OK);
	}
	
	//FOR ADMIN
	@GetMapping("/getAllBloodUserDetails")
	public List<BloodUser> getAllBloodUsers(){
		return us.fetchAllBloodUserDetails();
	}
}
