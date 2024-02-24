package com.bloodbank.sbbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bloodbank.sbbm.entity.Donor;

//repository to get predefined methods of JpaRepository for Donor Entity
public interface DonorRepository  extends JpaRepository<Donor, Integer>{

	//custom query
	@Query("Select d from Donor d where d.donorBloodGroup=?1")
	List<Donor>  findByBloodGroup(String donorBloodGroup);
}
