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
public class Donor {

	@Id
	private int donorId;
	
	@Column(length=25, nullable = false)
	private String donorName;
	
	@Column(length=20, nullable = false)
	private String donorBloodGroup;
	
	@Column(length=12, nullable = false, unique = true)
	private long donorContact;
}
