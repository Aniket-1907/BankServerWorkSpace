package com.cg.bankapp.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.cg.bankapp.command.AccountCreateCommand;
import com.cg.bankapp.command.AccountUpdateCommand;
import com.cg.bankapp.command.AccountUpdateRollbackCommand;
import com.cg.bankapp.command.events.AccountCreateEvent;
import com.cg.bankapp.command.events.AccountUpdateEvent;
import com.cg.bankapp.command.events.AccountUpdateRollbackEvent;

@Aggregate
public class AccountAggregate {

	@AggregateIdentifier
	private String uid;
	private int accountNumber;
	private double balance;
	private int customerId;
	private String transaction_type;
	private double amount;
	
	@CommandHandler
	public AccountAggregate(AccountCreateCommand accountCommand) {

		AccountCreateEvent accountCreateEvent = new AccountCreateEvent();
		BeanUtils.copyProperties(accountCommand, accountCreateEvent);
		AggregateLifecycle.apply(accountCreateEvent);
		
	}
	
	@CommandHandler
	public AccountAggregate(AccountUpdateCommand accountUpdateCommand) {
		
		AccountUpdateEvent accountUpdateEvent = new AccountUpdateEvent();
		BeanUtils.copyProperties(accountUpdateCommand, accountUpdateEvent);
		AggregateLifecycle.apply(accountUpdateEvent);
		
	}
	
	@CommandHandler
	public AccountAggregate(AccountUpdateRollbackCommand accountUpdateRollbackCommand) {
		
		AccountUpdateRollbackEvent accountUpdateRollbackEvent = new AccountUpdateRollbackEvent();
		BeanUtils.copyProperties(accountUpdateRollbackCommand, accountUpdateRollbackEvent);
		AggregateLifecycle.apply(accountUpdateRollbackEvent);
		
	}
	
	@EventSourcingHandler
	public void accountEventSourcingHandler(AccountCreateEvent accountCreateEvent) {
		
		this.uid = accountCreateEvent.getUid();
		this.accountNumber = accountCreateEvent.getAccountNumber();
		this.balance = accountCreateEvent.getBalance();
		this.customerId = accountCreateEvent.getCustomerId();
		
	}
	
	@EventSourcingHandler
	public void accountEventSourcingHandler(AccountUpdateEvent accountUpdateEvent) {

		this.uid = accountUpdateEvent.getUid();
		this.accountNumber = accountUpdateEvent.getAccountNumber();
		this.balance = accountUpdateEvent.getBalance();
		this.customerId = accountUpdateEvent.getCustomerId();
		
	}
	
	@EventSourcingHandler
	public void accountEventSourcingHandler(AccountUpdateRollbackEvent accountUpdateRollbackEvent) {
		
		this.uid = accountUpdateRollbackEvent.getUid();
		this.accountNumber = accountUpdateRollbackEvent.getAccountNumber();
		this.balance = accountUpdateRollbackEvent.getBalance();
		this.customerId = accountUpdateRollbackEvent.getCustomerId();
		this.transaction_type = accountUpdateRollbackEvent.getTransaction_type();
		this.amount = accountUpdateRollbackEvent.getAmount();
		
	}

}
