package com.cg.bankapp.query.projections;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.query.GetTransactionsByAccountNoQuery;
import com.cg.bankapp.query.entites.Transaction;
import com.cg.bankapp.query.repositories.TransactionQueryRepository;

@Component
public class TransactionProjection {

	@Autowired
	private TransactionQueryRepository transactionDAO;
	
	@QueryHandler
	public List<Transaction> handelGetTransactionQuery(GetTransactionsByAccountNoQuery getTransactionByAccountNoQuery) {
		return transactionDAO.findAllByAccountNumber(getTransactionByAccountNoQuery.getAccountNumber());
	}
	
}