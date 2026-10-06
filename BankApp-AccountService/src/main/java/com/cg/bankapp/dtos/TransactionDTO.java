package com.cg.bankapp.dtos;

import lombok.Data;

@Data

public class TransactionDTO {

	private int transactionId;
	private double amount;
	private double balance;
	private String date;
	private String transaction_type;
	private int accountNumber;

	public TransactionDTO() {}

	public TransactionDTO(double amount, double balance, String date, String transaction_type, int accountNumber) {

		this.amount = amount;
		this.balance = balance;
		this.date = date;
		this.transaction_type = transaction_type;
		this.accountNumber = accountNumber;

	}

	
}
