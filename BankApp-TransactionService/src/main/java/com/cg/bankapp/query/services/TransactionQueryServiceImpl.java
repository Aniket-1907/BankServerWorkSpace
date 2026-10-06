package com.cg.bankapp.query.services;

import java.util.List;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.query.GetTransactionsByAccountNoQuery;
import com.cg.bankapp.query.entites.Transaction;

@Component
public class TransactionQueryServiceImpl implements TransactionQueryService{
	
	@Autowired private CommandGateway commandGateway;
	
	@Autowired private QueryGateway queryGateway;
	
	@Override
	public List<Transaction> getTransactions(int accountNumber) {
		return queryGateway.query(new GetTransactionsByAccountNoQuery(accountNumber), ResponseTypes.multipleInstancesOf(Transaction.class)).join();
	}
	
		
		
	
}