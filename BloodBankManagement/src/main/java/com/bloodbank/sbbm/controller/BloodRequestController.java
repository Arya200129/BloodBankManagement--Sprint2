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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.sbbm.entity.BloodRequest;
import com.bloodbank.sbbm.service.BloodRequestService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BloodRequestController {

	@Autowired
	BloodRequestService rs;
	
	@PostMapping("/saveBloodRequest")
	public ResponseEntity<BloodRequest> saveBloodRequest(@Valid @RequestBody BloodRequest bloodRequest){
		return new ResponseEntity<BloodRequest>(rs.addBloodRequest(bloodRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("/getBloodRequestDetails/{requestId}")
	public ResponseEntity<BloodRequest> fetchBloodRequest(@PathVariable("requestId") int requestId){
		return new ResponseEntity<BloodRequest>(rs.fetchBloodRequestDetail(requestId), HttpStatus.OK);	
	}
	
	@DeleteMapping("/deleteBloodRequest/{requestId}")
	public ResponseEntity<String> deleteBloodRequest(@PathVariable("requestId") int requestId){
		rs.removeBloodRequest(requestId);
		return new ResponseEntity<String>("Deleted BloodRequest Record", HttpStatus.OK);
	}
	
	@PostMapping("/newRequest")
	public ResponseEntity<String> addNewRequest(@RequestBody BloodRequest bloodRequest, @RequestParam int bloodUserId) {
		rs.addNewRequest(bloodRequest, bloodUserId);
		return new ResponseEntity<String>("applied new request successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getBloodRequestByUserId/{bloodUserId}")
	public List<BloodRequest> getBloodRequestByUserId(@PathVariable("bloodUserId") int bloodUserId){
		return rs.fetchBloodRequestDetails1(bloodUserId);
	}
	
	//FOR ADMIN
	@PutMapping("/setStatus/{requestId}")
	public ResponseEntity<BloodRequest> setStatus(@Valid@PathVariable("requestId") int requestId, @RequestBody BloodRequest bloodRequest){
			
		return new ResponseEntity<BloodRequest>(rs.editBloodRequest(bloodRequest, requestId), HttpStatus.OK);
	}
	
	@GetMapping("/getAllBloodRequestDetails")
	public List<BloodRequest> getAllBloodRequests(){
		return rs.fetchAllBloodRequestDetails();
	}
}
