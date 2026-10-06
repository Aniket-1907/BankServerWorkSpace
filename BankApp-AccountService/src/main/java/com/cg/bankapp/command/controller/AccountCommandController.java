package com.cg.bankapp.command.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.command.entities.Account;
import com.cg.bankapp.command.services.AccountCommandServices;
import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.exceptions.BankingServicesException;
import com.cg.bankapp.exceptions.FundTransferInSameAccountException;
import com.cg.bankapp.exceptions.InsufficientBalanceException;
import com.cg.bankapp.exceptions.NegativeAmounException;

@RestController
public class AccountCommandController {
	
	@Autowired
	private AccountCommandServices services;

	@PostMapping (value = "/addAccountDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addAccountDetails(@RequestBody Account account) {
		return new ResponseEntity<>(services.addAccountDetails(account), HttpStatus.OK);
	}
	
	@PostMapping(value = {"/withdrawAmount"})
	public ResponseEntity<Object> withdrawAmount(@RequestParam int accountNumber, @RequestParam double amount) throws AccountNotFoundException, InsufficientBalanceException, NegativeAmounException,BankingServicesException {
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
			"accountNumber", accountNumber,
			"withdrawnAmount", amount,
			"updateBalance", services.withdrawAmount(accountNumber, amount)
		));
	}
	
	@PostMapping(value = {"/depositAmount"})
	public ResponseEntity<Object> depositAmount(@RequestParam int accountNumber, @RequestParam double amount) throws AccountNotFoundException, BankingServicesException ,NegativeAmounException{
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
			"accountNumber", accountNumber,
			"depositAmount", amount,
			"updateBalance", services.depositAmount(accountNumber, amount)
		));
	}
	
	@PostMapping(value = {"/fundTransfer"})
	public ResponseEntity<Object> fundTransfer(@RequestParam int srcAccountNumber, @RequestParam int destAccountNumber, @RequestParam double amount) throws AccountNotFoundException, InsufficientBalanceException, BankingServicesException, NegativeAmounException,FundTransferInSameAccountException {
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
			"sourceAccountNumber", srcAccountNumber,
			"destinationAccountNumber", destAccountNumber,
			"transactionAmount", amount,
			"updatedBalance", services.fundTransfer(srcAccountNumber, destAccountNumber, amount)
		));
	}

}
