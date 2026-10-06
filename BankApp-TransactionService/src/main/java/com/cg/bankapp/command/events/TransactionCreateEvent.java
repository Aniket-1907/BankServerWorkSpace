package com.cg.bankapp.command.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCreateEvent {
	private String uid;
	private int transactionId;
	private String date;
	private double amount;
	private double balance;
	private String transaction_type;
	private int accountNumber;
}
