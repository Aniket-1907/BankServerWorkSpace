package com.cg.bankapp.query.services;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.query.GetAccountByAccountNumberQuery;
import com.cg.bankapp.query.entities.Account;

@Component
public class AccountQueryServiceImpl implements AccountQueryService {
	
	@Autowired
	private QueryGateway queryGateway;

	@Override
	public double getBalance(int accountNumber) throws AccountNotFoundException {
		return queryGateway.query(new GetAccountByAccountNumberQuery(accountNumber), ResponseTypes.instanceOf(Account.class)).join().getBalance();
	}

}
