package com.bloodbank.sbbm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.sbbm.entity.Donor;
import com.bloodbank.sbbm.exception.DonorIdNotFoundException;
import com.bloodbank.sbbm.repository.DonorRepository;
import com.bloodbank.sbbm.service.DonorService;

@Service
public class DonorServiceImpl implements DonorService{

	@Autowired
	DonorRepository drepo;
	
	@Override
	public List<Donor> fetchDonorListDetails() {
		return drepo.findAll();
	}

	@Override
	public List<Donor> fetchDonorByBloodGroup(String donorBloodGroup) {
		return drepo.findByBloodGroup(donorBloodGroup);
	}

	//admin side
	
	@Override
	public Donor addDonor(Donor donor) {
		return drepo.save(donor);
	}

	@Override
	public void removeDonor(int donorId) {
		drepo.findById(donorId).orElseThrow(()-> new DonorIdNotFoundException("Donor ID is invalid/incorrect"));
		drepo.deleteById(donorId);
	}

	@Override
	public Donor editDonor(Donor donor, int donorId) {
		
		Donor updatedDonor = drepo.findById(donorId).orElseThrow(()-> new DonorIdNotFoundException("Donor ID is invalid/incorrect"));
		
		updatedDonor.setDonorName(donor.getDonorName());
		updatedDonor.setDonorBloodGroup(donor.getDonorBloodGroup());
		updatedDonor.setDonorContact(donor.getDonorContact());
		
		drepo.save(updatedDonor);
		return updatedDonor;
	}
	
}
