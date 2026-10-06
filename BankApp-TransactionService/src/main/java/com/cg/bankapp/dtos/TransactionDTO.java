package com.cg.bankapp.dtos;

import lombok.Data;

@Data
public class TransactionDTO {
	private int transactionId;
	private String date;
	private double amount;
	private double balance;
	private String transaction_type;
	private int accountNumber;
}
