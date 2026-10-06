package com.cg.bankapp.query;

import lombok.Data;

@Data
public class GetTransactionsByAccountNoQuery {

	private int accountNumber;

	public GetTransactionsByAccountNoQuery(int accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	
}
