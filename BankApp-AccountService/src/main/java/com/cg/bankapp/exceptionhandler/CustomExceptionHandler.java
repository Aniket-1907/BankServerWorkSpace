package com.cg.bankapp.exceptionhandler;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.exceptions.BankingServicesException;
import com.cg.bankapp.exceptions.FundTransferInSameAccountException;
import com.cg.bankapp.exceptions.InsufficientBalanceException;
import com.cg.bankapp.exceptions.NegativeAmounException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
			"exception", e.getClass(),
			"message", e.getMessage()
		));
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleInsufficientBalanceException(InsufficientBalanceException e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of(
			"exception", e.getClass(),
			"message", e.getMessage()
		));
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleNegativeAmounException(NegativeAmounException e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of(
			"exception", e.getClass(),
			"message", e.getMessage()
		));
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleBankServicesException(BankingServicesException e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of(
			"exception", e.getClass(),
			"message", e.getMessage()
		));
	}

	@ExceptionHandler
	public ResponseEntity<Object> handleFundTransferInSameAccountException(FundTransferInSameAccountException e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of(
			"exception", e.getClass(),
			"message", e.getMessage()
		));
	}
		
}
