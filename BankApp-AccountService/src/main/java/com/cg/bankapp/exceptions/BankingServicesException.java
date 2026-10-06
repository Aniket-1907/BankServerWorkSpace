package com.cg.bankapp.exceptions;

public class BankingServicesException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public BankingServicesException() {}

	public BankingServicesException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
