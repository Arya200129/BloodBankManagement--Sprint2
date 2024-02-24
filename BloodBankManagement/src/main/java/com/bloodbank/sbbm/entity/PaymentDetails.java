package com.bloodbank.sbbm.entity;

//import com.fasterxml.jackson.annotation.JsonBackReference;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/*import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;*/
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PaymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ppid;
	
	@NotNull(message="Add amount to proceed")
	private long amount;
	
	@NotBlank(message="Mandatory to add mode")
	@Column(length=15, nullable=false)
	private String paymentMode;
	
	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JoinColumn(name="bloodUserId", referencedColumnName = "userId")
	//@JsonBackReference
	//private BloodUser bloodUser;

    /*@OneToOne
    @MapsId
    @JoinColumn(name="requestId")
    private BloodRequest bloodRequest;*/
}
