package com.bloodbank.sbbm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
/*import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;*/
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	
	@NotBlank(message="Blood Group is mandotory to mention")
	@Column(length=15, nullable = false)
	private String RequestedBloodGroup;
	
	@NotBlank(message="RequestDate is mandotory to mention")
	@Column(length=10, nullable = false)
	private String RequestDate;
	
	//@NotBlank(message="status is mandotory")
	@Column(length=15, nullable = false)
	private String status = "pending"; //accepted, rejected, pending

	@NotBlank(message="Blood Bank Name/Donor Name is mandotory")
	@Column(length=50, nullable = false)
	private String blookBankName_donorName;
	
	@ManyToOne()
	@JoinColumn(name="bloodUserId", referencedColumnName = "userId")
	@JsonBackReference
	private BloodUser bloodUser;
	
	/*@OneToOne(mappedBy = "bloodRequest", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private PaymentDetails paymentDetails; // One-to-one relationship with Payment
	*/
}
