package com.cg.bankapp.query.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.dtos.TransactionDTO;
//import com.cg.bankapp.dtos.AccountDTO;
import com.cg.bankapp.query.entites.Transaction;
import com.cg.bankapp.query.services.TransactionQueryService;


@RestController
public class TransactionQueryController {
	
	@Autowired
	private TransactionQueryService service;
	
	@GetMapping("/getTransactions")
	ResponseEntity<List<TransactionDTO>> getTransactions(@RequestParam int accountNumber){
		List<Transaction> transactions= service.getTransactions(accountNumber);
		List<TransactionDTO> transactionDTOs=new ArrayList<>();
		for (Transaction transaction : transactions) {
			TransactionDTO transactionDTO=new TransactionDTO();
			BeanUtils.copyProperties(transaction, transactionDTO);
			transactionDTOs.add(transactionDTO);
		}
		System.out.println(transactionDTOs);
		return new ResponseEntity<>(transactionDTOs, HttpStatus.OK);
	}
	

}