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

import com.bloodbank.sbbm.entity.BloodBankList;
import com.bloodbank.sbbm.service.BloodBankListService;

import jakarta.validation.Valid;

//Controller for all incoming requests on bloodBankList entity

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BloodBankListController {

	@Autowired
	BloodBankListService bbs;
	
	//get mapping to fetch all bloodbanks list
	@GetMapping("/getBloodBanks")
	public List<BloodBankList> getBloodBanks(){
		return bbs.fetchBloodBankListDetails();
	}
	
	//get mapping with parameter for bloodbank list as per location
	@GetMapping("/getBloodBankByLocation/{bloodBankLocation}")
	public List<BloodBankList> getBloodBankByLocation(@PathVariable("bloodBankLocation") String bloodBankLocation){
		return bbs.fetchBloodBankListDetails1(bloodBankLocation);
	}
	
	
	//FOR ADMIN
	@PostMapping("/addBloodBank")
	public ResponseEntity<BloodBankList> saveBloodBank(@Valid@RequestBody BloodBankList bloodBank){
		
		return new ResponseEntity<BloodBankList>(bbs.addBloodBank(bloodBank),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteBloodBank/{bloodBankId}")
	public ResponseEntity<String> deleteBloodBank(@PathVariable("bloodBankId") int bloodBankId){
		bbs.removeBloodBank(bloodBankId);
		return new ResponseEntity<String>("Blood Bank record deleted successfully!", HttpStatus.OK);
	}
	
	@PutMapping("/editBloodBank/{bloodBankId}")
	public ResponseEntity<BloodBankList> editBloodBanks(@Valid @PathVariable("bloodBankId") int bloodBankId, @RequestBody BloodBankList bloodBank){
		
		return new ResponseEntity<BloodBankList>(bbs.editBloodBank(bloodBank, bloodBankId), HttpStatus.OK);
	}
	
}
