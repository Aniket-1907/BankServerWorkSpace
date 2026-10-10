package com.cg.bankapp.command.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.bankapp.command.entities.Customer;
import com.cg.bankapp.command.service.CustomerCommandService;
import com.cg.bankapp.dtos.CustomerDTO;
import com.cg.bankapp.dtos.UserDTO;
import com.netflix.appinfo.AmazonInfo;

@RestController
public class CustomerCommandController {
	
	
	@Autowired private CustomerCommandService service; 

	@PostMapping (value = "/addCustomerDetails" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> addCustomerDetails(@RequestBody UserDTO userDTO){
		Customer  customer = new Customer();
		BeanUtils.copyProperties(userDTO, customer);
		CustomerDTO responseCustomerDTO = new CustomerDTO();
		BeanUtils.copyProperties(service.addCustomerDetails(customer,userDTO.getPassword()), responseCustomerDTO);
		return new ResponseEntity<CustomerDTO>(responseCustomerDTO,HttpStatus.OK) ;	
	}
	@PostMapping (value = "/updateCustomerDetails" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> updateCustomerDetails(@RequestBody CustomerDTO recivedCustomerDTO){
		Customer  customer = new Customer();
		BeanUtils.copyProperties(recivedCustomerDTO, customer);
		CustomerDTO responseCustomerDTO = new CustomerDTO();
		BeanUtils.copyProperties(service.updateCustomerDetails(customer), responseCustomerDTO);
		return new ResponseEntity<CustomerDTO>(responseCustomerDTO,HttpStatus.OK) ;	
	}
	@DeleteMapping(value="/deleteCustomerDetails")
	public ResponseEntity<String> deleteCustomerDetails(@RequestParam int id){
		String message=null;
		if(service.deleteCustomerDetails(id)) {
			message ="Customer Deleted for id = "+id;
		}
		else {
			message ="No Customer Found for id = "+id;
		}
		return new ResponseEntity<String>(message,HttpStatus.OK) ;	
	}
}