package com.bloodbank.sbbm.exception;

public class BloodUserIDNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BloodUserIDNotFoundException(String message) {
		super(message);
	}
}
