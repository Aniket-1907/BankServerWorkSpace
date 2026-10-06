package com.cg.bankapp.query.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.dtos.CustomerDTO;
import com.cg.bankapp.exceptions.CustomerDetailsNotFoundException;
import com.cg.bankapp.query.entites.Customer;
import com.cg.bankapp.query.services.CustomerQueryService;

@RestController
public class CustomerQueryController {
	
	@Autowired private CustomerQueryService service; 
	@GetMapping(value = "/getCustomerDetails" )
	public ResponseEntity<CustomerDTO> getCustomerDetails(int id) throws CustomerDetailsNotFoundException {
		Customer customer = service.getCustomerDetails(id);
		CustomerDTO customerDTO = new CustomerDTO();
		BeanUtils.copyProperties(customer, customerDTO);
		return new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.OK) ;
	}

}