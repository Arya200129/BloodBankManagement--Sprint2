package com.bloodbank.sbbm.exception;

public class DonorIdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DonorIdNotFoundException(String message) {
		super(message);
	}
}
