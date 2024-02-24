package com.bloodbank.sbbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bloodbank.sbbm.entity.BloodUser;

//repository to get predefined methods of JpaRepository for BloodUser Entity
public interface BloodUserRepository extends JpaRepository<BloodUser, Integer> {

	//custom query
	@Query("Select bu from BloodUser bu where bu.userEmail=?1")
	BloodUser findByEmail(String userEmail);
}
