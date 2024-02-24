package com.bloodbank.sbbm.service;

import java.util.List;

import com.bloodbank.sbbm.entity.BloodUser;

//abstract method for performing CRUD on entity BloodUser 
public interface BloodUserService {
	
	//register a new BloodUser in db table
	BloodUser registerBloodUser(BloodUser bloodUser);
	
	//edit existing BloodUser details based on id from db table
	BloodUser editBloodUser(BloodUser bloodUser, int userId);
	
	//remove existing BloodUser details based on id from db table
	void deleteBloodUser(int userId);
	
	//fetch BloodUser details based on id from db table
	BloodUser fetchBloodUser(int userId);
	
	//login BloodUser details based on email from db table
	int login(String userEmail, String password);
	
	//admin
	//fetch all blood users from table
	List<BloodUser> fetchAllBloodUserDetails();
}
