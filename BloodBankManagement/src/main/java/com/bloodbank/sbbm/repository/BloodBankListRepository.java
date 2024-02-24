package com.bloodbank.sbbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bloodbank.sbbm.entity.BloodBankList;

//Repository to get predefined method of JpaRepository for Entity BloodBankList 
public interface BloodBankListRepository extends JpaRepository<BloodBankList, Integer>{
	
	//custom query using jpql
	//fetching bloodbank list as per location
	@Query("Select bbl from BloodBankList bbl where bbl.bloodBankLocation=?1")
	List<BloodBankList>  findByLocation(String bloodBankLocation);
	
}
