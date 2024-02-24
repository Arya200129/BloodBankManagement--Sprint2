package com.bloodbank.sbbm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.sbbm.entity.BloodRequest;
import com.bloodbank.sbbm.entity.BloodUser;
import com.bloodbank.sbbm.exception.BloodRequestIdNotFoundException;
import com.bloodbank.sbbm.exception.BloodUserIDNotFoundException;
import com.bloodbank.sbbm.repository.BloodRequestRepository;
import com.bloodbank.sbbm.repository.BloodUserRepository;
import com.bloodbank.sbbm.service.BloodRequestService;

@Service
public class BloodRequestServiceImpl implements BloodRequestService{

	@Autowired
	BloodRequestRepository requestRepo;
	
	@Autowired
	BloodUserRepository userRepo;

	@Override
	public BloodRequest addBloodRequest(BloodRequest bloodRequest) {
		return requestRepo.save(bloodRequest);
	}

	@Override
	public void removeBloodRequest(int requestId) {
		requestRepo.findById(requestId).orElseThrow(() -> new BloodRequestIdNotFoundException("Entered Request ID is invalid/incorrect"));
		requestRepo.deleteById(requestId);
	}

	@Override
	public BloodRequest fetchBloodRequestDetail(int requestId) {
		return requestRepo.findById(requestId).orElseThrow(() -> new BloodRequestIdNotFoundException("Entered Request ID is invalid/incorrect"));
	}

	@Override
	public void addNewRequest(BloodRequest bloodRequest, int bloodUserId) {
		
		//finds user object 
		BloodUser bloodUser = userRepo.findById(bloodUserId).orElseThrow(() -> new BloodUserIDNotFoundException("BloodUser ID is incorrect/invalid"));

		// Set the status as "pending" for all new requests
        bloodRequest.setStatus("pending");
		
		//BloodRequest bloodRequest = new BloodRequest();
		bloodRequest.setBloodUser(bloodUser);
		requestRepo.save(bloodRequest);
	}

	@Override
	public List<BloodRequest> fetchBloodRequestDetails1(int bloodUserId) {
		
		return requestRepo.findByUserId(bloodUserId);
	}

	//admin side
	
	@Override
	public BloodRequest editBloodRequest(BloodRequest bloodRequest, int requestId) {

		//fetch bloodUser data based on id, if not found throw exception
		BloodRequest updatedBloodRequest = requestRepo.findById(requestId).orElseThrow(() -> new BloodRequestIdNotFoundException("Entered Request ID is invalid/incorrect"));
		
		//set new values to bloodUser entity
		updatedBloodRequest.setStatus(bloodRequest.getStatus());
		
		requestRepo.save(updatedBloodRequest);
		return updatedBloodRequest;
	}

	@Override
	public List<BloodRequest> fetchAllBloodRequestDetails() {
		return requestRepo.findAll();
	}

}
