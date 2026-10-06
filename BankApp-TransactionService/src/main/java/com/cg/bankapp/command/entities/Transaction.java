package com.cg.bankapp.command.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity(name = "transaction_Command")
public class Transaction{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int transactionId;
	private String date;
	private double amount;
	private double balance;
	private String transaction_type;
	private int accountNumber;
	
	public Transaction() {}
	
	public Transaction( String date, double amount, double balance, String transaction_type,
			int accountNumber) {
		this.date = date;
		this.amount = amount;
		this.balance = balance;
		this.transaction_type = transaction_type;
		this.accountNumber = accountNumber;
	}

}