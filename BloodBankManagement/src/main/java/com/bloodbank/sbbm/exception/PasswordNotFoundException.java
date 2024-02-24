package com.bloodbank.sbbm.exception;

public class PasswordNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PasswordNotFoundException(String message) {
		super(message);
	}
}
