package com.cg.bankapp.command.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.command.entities.Transaction;
import com.cg.bankapp.command.service.TransactionCommandService;
import com.cg.bankapp.dtos.TransactionDTO;

@RestController
public class TransactionCommandController {
	
	@Autowired
	private TransactionCommandService commandService;
	
	@PostMapping (value = "/addTransaction" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionDTO recivedTransactionDTO){
		Transaction  transaction = new Transaction();
		BeanUtils.copyProperties(recivedTransactionDTO, transaction);
		TransactionDTO responseTransactionDTO = new TransactionDTO();
		BeanUtils.copyProperties(commandService.createTransaction(transaction), responseTransactionDTO);
		return new ResponseEntity<TransactionDTO>(responseTransactionDTO,HttpStatus.OK) ;	
	}
}
