package com.bloodbank.sbbm.service;

import java.util.List;

import com.bloodbank.sbbm.entity.BloodRequest;

public interface BloodRequestService {

	//add an new BloodRequest in db table
	BloodRequest addBloodRequest(BloodRequest bloodRequest);
	
	//add an new BloodRequest of existing user
	public void addNewRequest(BloodRequest bloodRequest, int bloodUserId);
	
	//remove existing BloodRequest record based on id from db table
	void removeBloodRequest(int requestId);
	
	//fetch BloodRequest details based on from db table
	BloodRequest fetchBloodRequestDetail(int requestId);
	
	//fetch all blood request list from table as per user id
	List<BloodRequest> fetchBloodRequestDetails1(int bloodUserId);
	
	//admin side
	
	//edit existing BloodUser details based on id from db table
	BloodRequest editBloodRequest(BloodRequest bloodRequest, int requestId);
	
	//fetch all blood requests from table
	List<BloodRequest> fetchAllBloodRequestDetails();
}
