package com.bloodbank.sbbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bloodbank.sbbm.entity.BloodRequest;

public interface BloodRequestRepository  extends JpaRepository<BloodRequest, Integer>{

	//custom query using jpql
	//fetching request list as per user id
	@Query("SELECT br FROM BloodRequest br where br.bloodUser.userId =?1")
	List<BloodRequest>  findByUserId(int bloodUserId);
}
