package com.cg.bankapp.query.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.query.services.AccountQueryService;

@RestController
public class AccountQueryController {
	
	@Autowired
	private AccountQueryService service;
	
	@GetMapping(value = {"/getBalance"})
	public ResponseEntity<Object> getBalance(@RequestParam int accountNumber) throws AccountNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
			"accountNumber", accountNumber,
			"balance", service.getBalance(accountNumber)
		));
	}

}
