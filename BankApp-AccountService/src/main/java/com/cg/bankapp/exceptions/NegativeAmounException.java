package com.cg.bankapp.exceptions;

public class NegativeAmounException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public NegativeAmounException() {}

	public NegativeAmounException(String errorMessage) {
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