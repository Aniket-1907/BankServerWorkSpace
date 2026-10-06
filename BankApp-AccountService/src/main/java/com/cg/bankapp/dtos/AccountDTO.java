package com.cg.bankapp.dtos;

import lombok.Data;

@Data
public class AccountDTO {
	
	private int accountNumber;
	private double balance;
	private int customerId;

}
