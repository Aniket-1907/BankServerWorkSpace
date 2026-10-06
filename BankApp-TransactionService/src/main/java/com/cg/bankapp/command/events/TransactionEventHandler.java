package com.cg.bankapp.command.events;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.query.entites.Transaction;
import com.cg.bankapp.query.repositories.TransactionQueryRepository;

@Component
@ProcessingGroup("account")
public class TransactionEventHandler {

	@Autowired
	private TransactionQueryRepository transactionDAO;
	
	@EventHandler  
	Transaction on(TransactionCreateEvent transactionCreateEvent) {
		Transaction Entity =  new Transaction();
		BeanUtils.copyProperties(transactionCreateEvent, Entity);	
		return transactionDAO.save(Entity);
	}
	
	
	
	
	
	
}
