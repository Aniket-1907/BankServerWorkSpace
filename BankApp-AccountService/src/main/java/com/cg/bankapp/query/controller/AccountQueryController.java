package com.cg.bankapp.query.controller;

import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(value = {"/convertXML"})
	public ResponseEntity<Object> convertXML(@RequestBody String xml) throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		JsonNode jsonNode=xmlMapper.readTree(xml);
		ObjectMapper objectMapper = new ObjectMapper();
		String json= objectMapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(jsonNode);
		return ResponseEntity
				.status(HttpStatus.OK)
				.header("Content-Type", "application/json")
				.header("converted-from", "application/xml")
				.header("converted-to", "application/json")
				.body(json);
	}



}
