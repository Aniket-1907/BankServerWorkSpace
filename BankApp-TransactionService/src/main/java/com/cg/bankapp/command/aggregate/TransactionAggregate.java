package com.cg.bankapp.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.cg.bankapp.command.TransactionCreateCommand;
import com.cg.bankapp.command.events.TransactionCreateEvent;

import lombok.extern.slf4j.Slf4j;

@Aggregate
@Slf4j
public class TransactionAggregate {
	@AggregateIdentifier
	private String uid;
	private int transactionId;
	private String date;
	private double amount;
	private double balance;
	private String transaction_type;
	private int accountNumber;
	
	
	@CommandHandler
	public  TransactionAggregate(TransactionCreateCommand transactionCommand) {
		TransactionCreateEvent transactionCreateEvent = new TransactionCreateEvent();
		BeanUtils.copyProperties(transactionCommand	, transactionCreateEvent);
		AggregateLifecycle.apply(transactionCreateEvent);
	}
	
	@EventSourcingHandler
	public void TransactionEventSourcingHandler(TransactionCreateEvent transactionCreateEvent) {
		this.transactionId=transactionCreateEvent.getTransactionId();
		this.uid =transactionCreateEvent.getUid();
		this.date=transactionCreateEvent.getDate();
		this.amount=transactionCreateEvent.getAmount();
		this.balance=transactionCreateEvent.getBalance();
		this.transaction_type=transactionCreateEvent.getTransaction_type();
		this.accountNumber=transactionCreateEvent.getAccountNumber();
	}

	
}