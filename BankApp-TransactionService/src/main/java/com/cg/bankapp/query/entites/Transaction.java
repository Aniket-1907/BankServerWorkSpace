package com.cg.bankapp.query.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity(name = "transaction_Query")
public class Transaction {

	@Id
	private int transactionId;
	@Column(unique = true)
	private String uid;

	private String date;
	private double amount;
	private double balance;
	private String transaction_type;
	private int accountNumber;
	
	public Transaction() {
	}

	public Transaction(String date,  double amount, double balance,
			String transaction_type, int accountNumber){

		this.date = date;
		this.amount = amount;
		this.balance = balance;
		this.transaction_type = transaction_type;
		this.accountNumber = accountNumber;
	}

	
}