package com.cg.bankapp.exceptions;

public class AccountNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public AccountNotFoundException() {}

	public AccountNotFoundException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}
	
	@Override
	public String getMessage() {
		return errorMessage;
	}

}
