package com.bloodbank.sbbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.sbbm.entity.PaymentDetails;

public interface PaymentRepository extends JpaRepository<PaymentDetails, Integer>{

}
