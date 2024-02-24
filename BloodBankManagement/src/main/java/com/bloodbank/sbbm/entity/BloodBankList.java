package com.bloodbank.sbbm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BloodBankList {

	@Id
	private int bloodBankId;
	
	@Column(length = 50, nullable = false)
	private String bloodBankName;
	
	@Column(length = 50, nullable = false)
	private String bloodBankLocation;

	@Column(length = 12, nullable = false, unique = true)
	private long bloodBankContact;
	
	@Column(length = 50, nullable = false)
	private String addr;
	
}
