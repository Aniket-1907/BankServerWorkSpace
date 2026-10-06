package com.cg.bankapp.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.cg.bankapp.command.TransactionEntryFailedCommand;
import com.cg.bankapp.command.events.TransactionEntryFailedEvent;

@Aggregate
public class TransactionAggregate {
	
	@AggregateIdentifier
	private String uid;
	private int transactionId;
	private double amount;
	private double balance;
	private String date;
	private String transaction_type;
	private int accountNumber;
	
	@CommandHandler
	public TransactionAggregate(TransactionEntryFailedCommand transactionEntryFailedCommand) {
		
		TransactionEntryFailedEvent transactionEntryFailedEvent = new TransactionEntryFailedEvent();
		BeanUtils.copyProperties(transactionEntryFailedCommand, transactionEntryFailedEvent);
		AggregateLifecycle.apply(transactionEntryFailedEvent);
		
	}
	
	@EventSourcingHandler
	public void accountEventSourcingHandler(TransactionEntryFailedEvent transactionEntryFailedEvent) {

		this.uid = transactionEntryFailedEvent.getUid();
		this.transactionId = transactionEntryFailedEvent.getTransactionId();
		this.amount = transactionEntryFailedEvent.getAmount();
		this.balance = transactionEntryFailedEvent.getBalance();
		this.date = transactionEntryFailedEvent.getDate();
		this.transaction_type = transactionEntryFailedEvent.getTransaction_type();
		this.accountNumber= transactionEntryFailedEvent.getAccountNumber();
		
	}

}
