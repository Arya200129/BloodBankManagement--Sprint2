package com.bloodbank.sbbm.service;

import java.util.List;

import com.bloodbank.sbbm.entity.BloodBankList;

public interface BloodBankListService {

	//fetch all blood bank list details from table
	List<BloodBankList> fetchBloodBankListDetails();
	
	//fetch all blood bank list from table as per location
	List<BloodBankList> fetchBloodBankListDetails1(String bloodBankLocation);
	
	//admin side
	
	//add an new BloodBank in db table
	BloodBankList addBloodBank(BloodBankList newbloodBank);
		
	//remove existing BloodBank record based on id from db table
	void removeBloodBank(int bloodBankId);
	
	//edit existing BloodBank details based on id from db table
	BloodBankList editBloodBank(BloodBankList bloodBank, int bloodBankId);
		
}
