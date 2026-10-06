package com.cg.bankapp.command.service;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.command.TransactionCreateCommand;
import com.cg.bankapp.command.entities.Transaction;
import com.cg.bankapp.command.repositories.TransactionCommandRepository;

@Component
public class TransactionCommandServiceImpl implements TransactionCommandService{

		@Autowired private CommandGateway commandGateway;
	
		@Autowired private TransactionCommandRepository repository;

		@Override
		public Transaction createTransaction(Transaction transaction) {
			transaction=repository.save(transaction);
			TransactionCreateCommand createCommand=TransactionCreateCommand.builder()
					.transactionId(transaction.getTransactionId())
					.uid(UUID.randomUUID().toString())
					.accountNumber(transaction.getAccountNumber())
					.date(transaction.getDate())
					.amount(transaction.getAmount())
					.balance(transaction.getBalance())
					.transaction_type(transaction.getTransaction_type())
					.build();
			commandGateway.sendAndWait(createCommand);
			return transaction;
		}

		
}