package com.bloodbank.sbbm.exception;

public class PaymentIdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PaymentIdNotFoundException(String message) {
		super(message);
	}
}
