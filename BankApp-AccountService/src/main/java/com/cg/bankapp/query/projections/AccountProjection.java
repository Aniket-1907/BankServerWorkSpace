package com.cg.bankapp.query.projections;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.query.GetAccountByAccountNumberQuery;
import com.cg.bankapp.query.entities.Account;
import com.cg.bankapp.query.repositories.AccountQueryRepository;

@Component
public class AccountProjection {
	
	@Autowired
	AccountQueryRepository accountDAO;
	
	@QueryHandler
	public Account handleGetAccountQuery(GetAccountByAccountNumberQuery getAccountByAccountNumberQuery) throws AccountNotFoundException {
		return accountDAO
				.findById(getAccountByAccountNumberQuery.getAccountNumber())
				.orElseThrow(() -> new AccountNotFoundException("Account Details Not Found For Account Number: " + getAccountByAccountNumberQuery.getAccountNumber()));
	}

}
