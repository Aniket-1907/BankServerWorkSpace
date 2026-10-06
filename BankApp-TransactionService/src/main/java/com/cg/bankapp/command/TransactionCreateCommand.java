package com.cg.bankapp.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionCreateCommand {
	@TargetAggregateIdentifier
	private String uid;
	private int transactionId;
	private String date;
	private double amount;
	private double balance;
	private String transaction_type;
	private int accountNumber;
}
