package com.bloodbank.sbbm.exception;

public class BloodRequestIdNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BloodRequestIdNotFoundException(String message) {
		super(message);
	}
}
