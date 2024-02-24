package com.bloodbank.sbbm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.sbbm.entity.BloodBankList;
import com.bloodbank.sbbm.exception.BloodBankIDNotFoundException;
import com.bloodbank.sbbm.repository.BloodBankListRepository;
import com.bloodbank.sbbm.service.BloodBankListService;

@Service
public class BloodBankListServiceImpl implements BloodBankListService{

	@Autowired
	BloodBankListRepository bbrepo;
	
	//using findAll() method of JpaRepository to fetch all list of bloodbank  
	@Override
	public List<BloodBankList> fetchBloodBankListDetails() {
		return bbrepo.findAll();
	}

	//using findByLocation() method of JpaRepository to fetch list as per location
	@Override
	public List<BloodBankList> fetchBloodBankListDetails1(String bloodBankLocation) {
		return bbrepo.findByLocation(bloodBankLocation);
	}
	
	//admin-side

	@Override
	public BloodBankList addBloodBank(BloodBankList newbloodBank) {
		return bbrepo.save(newbloodBank);
	}

	@Override
	public void removeBloodBank(int bloodBankId) {
		bbrepo.findById(bloodBankId).orElseThrow(() -> new BloodBankIDNotFoundException("BloodBank Id is incorrect/invalid"));
		bbrepo.deleteById(bloodBankId);
	}

	@Override
	public BloodBankList editBloodBank(BloodBankList bloodBank, int bloodBankId) {
		
		BloodBankList updatedBB = bbrepo.findById(bloodBankId).orElseThrow(() -> new BloodBankIDNotFoundException("BloodBank Id is incorrect/invalid"));
		
		updatedBB.setBloodBankName(bloodBank.getBloodBankName());
		updatedBB.setBloodBankLocation(bloodBank.getBloodBankLocation());
		updatedBB.setBloodBankContact(bloodBank.getBloodBankContact());
		updatedBB.setAddr(bloodBank.getAddr());
		
		bbrepo.save(updatedBB);
		return updatedBB;
	}

}
