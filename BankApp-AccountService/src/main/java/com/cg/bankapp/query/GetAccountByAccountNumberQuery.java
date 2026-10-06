package com.cg.bankapp.query;

import lombok.Data;

@Data
public class GetAccountByAccountNumberQuery {
	
	private int accountNumber;
	
	public GetAccountByAccountNumberQuery(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
