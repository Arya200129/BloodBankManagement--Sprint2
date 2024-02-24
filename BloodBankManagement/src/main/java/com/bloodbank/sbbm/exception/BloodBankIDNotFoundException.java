package com.bloodbank.sbbm.exception;

public class BloodBankIDNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public BloodBankIDNotFoundException(String message) {
		super(message);
	}
}
