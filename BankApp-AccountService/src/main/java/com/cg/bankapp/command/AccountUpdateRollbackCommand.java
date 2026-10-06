package com.cg.bankapp.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountUpdateRollbackCommand {

	@TargetAggregateIdentifier
	private String uid;

	private int accountNumber;
	private double balance;
	private int customerId;

	private String transaction_type;
	private double amount;

}
