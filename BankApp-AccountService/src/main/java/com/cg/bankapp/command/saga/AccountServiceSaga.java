package com.cg.bankapp.command.saga;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.cg.bankapp.command.AccountUpdateRollbackCommand;
import com.cg.bankapp.command.events.TransactionEntryFailedEvent;
import com.cg.bankapp.command.repositories.AccountCommandRepository;
import com.cg.bankapp.query.repositories.AccountQueryRepository;

@Saga
public class AccountServiceSaga {
	
	@Autowired
	transient private RestTemplate restTemplate;
	
	@Autowired
	transient private CommandGateway commandGateway;
	
	@Autowired
	transient private QueryGateway queryGateway;
	
	@Autowired
	transient private AccountQueryRepository accountQueryRepository;
	
	@Autowired
	transient private AccountCommandRepository accountCommandRepository;
	
	@StartSaga
	@SagaEventHandler(associationProperty = "uid")
	public void handleAccountUpdateEvent(TransactionEntryFailedEvent transactionEntryFailedEvent) {
		
		try {

			AccountUpdateRollbackCommand accountUpdateRollbackCommand = AccountUpdateRollbackCommand
					.builder()
					.uid(UUID.randomUUID().toString())
					.accountNumber(transactionEntryFailedEvent.getAccountNumber())
					.balance(transactionEntryFailedEvent.getBalance())
					.transaction_type(transactionEntryFailedEvent.getTransaction_type())
					.amount(transactionEntryFailedEvent.getAmount())
					.build();
			
			commandGateway.sendAndWait(accountUpdateRollbackCommand);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	@EndSaga
	public void on() {
		SagaLifecycle.end();
	}

}
