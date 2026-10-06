package com.cg.bankapp.command.services;

import com.cg.bankapp.command.entities.Account;
import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.exceptions.BankingServicesException;
import com.cg.bankapp.exceptions.FundTransferInSameAccountException;
import com.cg.bankapp.exceptions.InsufficientBalanceException;
import com.cg.bankapp.exceptions.NegativeAmounException;

public interface AccountCommandServices {
	
	public Account addAccountDetails(Account account);
	public double withdrawAmount(int accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException, BankingServicesException,NegativeAmounException;
	public double depositAmount(int accountNumber, double amount) throws AccountNotFoundException, BankingServicesException,NegativeAmounException;
	public double fundTransfer(int srcAccountNumber, int destAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException, BankingServicesException, FundTransferInSameAccountException,NegativeAmounException;

}
