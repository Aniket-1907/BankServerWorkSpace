package com.cg.bankapp.query.services;

import java.util.List;

//import com.cg.bankapp.dtos.AccountDTO;
import com.cg.bankapp.query.entites.Transaction;

public interface TransactionQueryService {

	
	List<Transaction> getTransactions(int accountId);
}