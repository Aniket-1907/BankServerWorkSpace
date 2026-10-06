package com.cg.bankapp.query.services;

import com.cg.bankapp.exceptions.AccountNotFoundException;

public interface AccountQueryService {
	public double getBalance(int account_no) throws AccountNotFoundException;
}
