package com.cg.bankapp.query.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity(name = "account_query")
public class Account {
	
	@Id
	private int accountNumber;
	@Column(unique = true)
	private String uid;
	private double balance;
	private int customerId;

	public Account() {}

	public Account(double balance, int customerId) {
		
		this.balance = balance;
		this.customerId = customerId;
		
	}

}
