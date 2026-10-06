package com.cg.bankapp.command.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateEvent {

	private String uid;
	private int accountNumber;
	private double balance;
	private int customerId;
	
}
