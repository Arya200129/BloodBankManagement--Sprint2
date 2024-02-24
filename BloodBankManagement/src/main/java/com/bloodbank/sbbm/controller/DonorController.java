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

import com.bloodbank.sbbm.entity.Donor;
import com.bloodbank.sbbm.service.DonorService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DonorController {

	@Autowired
	DonorService ds;
	
	@GetMapping("/getDonors")
	public List<Donor> getBloodDonors(){
		return ds.fetchDonorListDetails();
	}
		
	//get mapping with parameter for bloodbank list as per location
	@GetMapping("/getDonorByBloodGroup/{donorBloodGroup}")
	public List<Donor> getDonorByBloodGroup(@PathVariable("donorBloodGroup") String donorBloodGroup){
		return ds.fetchDonorByBloodGroup(donorBloodGroup);
	}
	
	//FOR ADMIN
	@PostMapping("/addDonor")
	public ResponseEntity<Donor> saveDonor(@Valid@RequestBody Donor donor){
			
		return new ResponseEntity<Donor>(ds.addDonor(donor),HttpStatus.CREATED);
	}
		
	@DeleteMapping("/deleteDonor/{donorId}")
	public ResponseEntity<String> deleteDonor(@PathVariable("donorId") int donorId){
		ds.removeDonor(donorId);
		return new ResponseEntity<String>("Donor record deleted successfully!", HttpStatus.OK);
	}
	
	@PutMapping("/editDonor/{donorId}")
	public ResponseEntity<Donor> editDonors(@Valid @PathVariable("donorId") int donorId, @RequestBody Donor donor){
		
		return new ResponseEntity<Donor>(ds.editDonor(donor, donorId), HttpStatus.OK);
	}
}
