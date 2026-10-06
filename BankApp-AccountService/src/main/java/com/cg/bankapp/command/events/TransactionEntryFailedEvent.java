package com.cg.bankapp.command.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntryFailedEvent {
	
	private String uid;
	private int transactionId;
	private double amount;
	private double balance;
	private String date;
	private String transaction_type;
	private int accountNumber;

}
