package com.cg.bankapp.command.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cg.bankapp.command.AccountCreateCommand;
import com.cg.bankapp.command.AccountUpdateCommand;
import com.cg.bankapp.command.TransactionEntryFailedCommand;
import com.cg.bankapp.command.entities.Account;
import com.cg.bankapp.command.repositories.AccountCommandRepository;
import com.cg.bankapp.dtos.TransactionDTO;
import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.exceptions.BankingServicesException;
import com.cg.bankapp.exceptions.FundTransferInSameAccountException;
import com.cg.bankapp.exceptions.InsufficientBalanceException;
import com.cg.bankapp.exceptions.NegativeAmounException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AccountCommandServicesImpl implements AccountCommandServices {
	
	@Autowired
	private CommandGateway commandGateway;
	
	@Autowired
	private AccountCommandRepository accountCommandRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Account addAccountDetails(Account account) {

		account = accountCommandRepository.save(account);
		AccountCreateCommand accountCommand = AccountCreateCommand
				.builder()
				.uid(UUID.randomUUID().toString())
				.accountNumber(account.getAccountNumber())
				.balance(account.getBalance())
				.customerId(account.getCustomerId())
				.build();
		
		commandGateway.sendAndWait(accountCommand);
		return account;

	}

	@Override
	public double withdrawAmount(int account_no, double amount) throws AccountNotFoundException, InsufficientBalanceException,NegativeAmounException, BankingServicesException {

		Account account = accountCommandRepository
				.findById(account_no)
				.orElseThrow(() -> new AccountNotFoundException("Account Details Not Found For AccountNumber: " + account_no));
		
		if (amount > account.getBalance()) {
			throw new InsufficientBalanceException("Withdraw Amount is Greater Than Available Balance");
		}

		if(amount<1) {
			throw new NegativeAmounException("Invalid Amount. Please Enter Amount greater then 1. ");
		}
		account.setBalance(account.getBalance() - amount);

		account = accountCommandRepository.save(account);

		TransactionDTO transactionDTO = new TransactionDTO(amount, account.getBalance(), LocalDateTime.now().toString(), "Debit", account_no);
		this.addTransaction(transactionDTO);
		
		AccountUpdateCommand accountUpdateCommand = AccountUpdateCommand
				.builder()
				.uid(UUID.randomUUID().toString())
				.accountNumber(account.getAccountNumber())
				.balance(account.getBalance())
				.customerId(account.getCustomerId())
				.build();
		System.out.println(accountUpdateCommand);
		commandGateway.sendAndWait(accountUpdateCommand);
		return account.getBalance();
		
	}

	@Override
	public double depositAmount(int account_no, double amount) throws AccountNotFoundException, NegativeAmounException,BankingServicesException {

		Account account = accountCommandRepository
				.findById(account_no)
				.orElseThrow(() -> new AccountNotFoundException("Account Details Not Found For AccountNumber: " + account_no));

		if(amount<1) {
			throw new NegativeAmounException("Invalid Amount. Please Enter Amount greater then 1. ");
		}
		account.setBalance(account.getBalance() + amount);

		account = accountCommandRepository.save(account);
		
		TransactionDTO transactionDTO = new TransactionDTO(amount, account.getBalance(), LocalDateTime.now().toString(), "Credit", account_no);
		this.addTransaction(transactionDTO);
		
		AccountUpdateCommand accountUpdateCommand = AccountUpdateCommand
				.builder()
				.uid(UUID.randomUUID().toString())
				.accountNumber(account.getAccountNumber())
				.balance(account.getBalance())
				.customerId(account.getCustomerId())
				.build();
		
		
		commandGateway.sendAndWait(accountUpdateCommand);
		return account.getBalance();

	}
	
	@Override
	public double fundTransfer(int srcAccountNumber, int destAccountNumber, double amount) throws AccountNotFoundException,NegativeAmounException, InsufficientBalanceException, BankingServicesException, FundTransferInSameAccountException {
		
		if (srcAccountNumber == destAccountNumber) {
			throw new FundTransferInSameAccountException("Source and Destination Accounts are same, i.e., " + srcAccountNumber);
		}

		if(amount<1) {
			throw new NegativeAmounException("Invalid Amount. Please Enter Amount greater then 1. ");
		}
		double updatedBalance = withdrawAmount(srcAccountNumber, amount);
		depositAmount(destAccountNumber, amount);
		
		return updatedBalance;

	}

	private void addTransaction(TransactionDTO transactionDTO) throws BankingServicesException {

		try {

			String uriEndPoint = "http://BankApp-TransactionService/transaction/addTransaction";
			String jsonData = new ObjectMapper().writeValueAsString(transactionDTO);
			HttpHeaders httpHeaders = new HttpHeaders();

			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> httpEntity = new HttpEntity<String>(jsonData, httpHeaders);
			restTemplate.postForObject(uriEndPoint, httpEntity, TransactionDTO.class);

		} catch (Exception e) {

			TransactionEntryFailedCommand transactionEntryFailedCommand = TransactionEntryFailedCommand
					.builder()
					.uid(UUID.randomUUID().toString())
					.transactionId(transactionDTO.getTransactionId())
					.amount(transactionDTO.getAmount())
					.balance(transactionDTO.getBalance())
					.date(transactionDTO.getDate())
					.transaction_type(transactionDTO.getTransaction_type())
					.accountNumber(transactionDTO.getAccountNumber())
					.build();
			
			commandGateway.sendAndWait(transactionEntryFailedCommand);
			throw new BankingServicesException("Bank Services are Not Working: " + e.getMessage());

		}

	}
	
}
