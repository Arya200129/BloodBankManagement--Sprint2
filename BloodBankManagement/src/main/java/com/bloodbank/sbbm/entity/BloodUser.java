package com.bloodbank.sbbm.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Blood User entity
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message = "First Name is mandatory to fill")
	private String userFirstName;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message = "Last Name is mandatory to fill")
	private String userLastName;
	
	@Column(length = 12, nullable = false, unique = true)
	@NotNull(message = "Contact Number is mandatory to fill")
	private long userContact;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "Email is mandatory to fill")
	@Email(message = "Email is not valid")
	private String userEmail;
	
	@Column(length = 70, nullable = false)
	private String addr;
	
	@NotBlank(message = "Please set your Password")
	@Column(length=15, nullable = false)
	private String password;

	@OneToMany(mappedBy="bloodUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JsonManagedReference
	List<BloodRequest> bloodRequestList;
}
