package com.cg.bankapp.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionEntryFailedCommand {

	@TargetAggregateIdentifier
	private String uid;
	private int transactionId;
	private double amount;
	private double balance;
	private String date;
	private String transaction_type;
	private int accountNumber;

}
