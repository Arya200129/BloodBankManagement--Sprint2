package com.bloodbank.sbbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bloodbank.sbbm.entity.AdminLogin;

public interface AdminLoginRepository extends JpaRepository<AdminLogin, Integer>{
	
	//custom query
	@Query("Select al from AdminLogin al where al.adminEmail=?1")
	AdminLogin findByEmail(String adminEmail);
}