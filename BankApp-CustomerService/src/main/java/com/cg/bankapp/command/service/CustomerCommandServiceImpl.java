package com.cg.bankapp.command.service;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cg.bankapp.command.CustomerCreateCommand;
import com.cg.bankapp.command.CustomerDeleteCommand;
import com.cg.bankapp.command.CustomerUpdateCommand;
import com.cg.bankapp.command.entities.Customer;
import com.cg.bankapp.command.repositories.CustomerCommandRepository;
import com.cg.bankapp.dtos.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomerCommandServiceImpl implements CustomerCommandService{

		@Autowired private CommandGateway commandGateway;
	
		@Autowired private CustomerCommandRepository repository;

		@Autowired private RestTemplate restTemplate;
		@Override
		public Customer  addCustomerDetails(Customer customer,String password) {
			addUser(UserDTO.builder().username(customer.getUsername()).password(password).build());
			customer = repository.save(customer);
			
			CustomerCreateCommand customerCommand = CustomerCreateCommand.builder()
						.id(customer.getId())
						.uid(UUID.randomUUID().toString())
						.firstName(customer.getFirstName())
						.lastName(customer.getLastName())
						.username(customer.getUsername())
						.build();
			commandGateway.sendAndWait(customerCommand);
			return customer;
		}

		@Override
		public Customer updateCustomerDetails(Customer customer) {
			Customer customer2=repository.findById(customer.getId()).orElseThrow(null);
			if(customer2==null) {
			}
			customer2.setId(customer.getId());
			customer2.setFirstName(customer.getFirstName());
			customer2.setLastName(customer.getLastName());
			customer2 = repository.save(customer2);
			CustomerUpdateCommand customerCommand = CustomerUpdateCommand.builder()
						.id(customer.getId())
						.uid(UUID.randomUUID().toString())
						.firstName(customer.getFirstName())
						.lastName(customer.getLastName())
						.build();
			commandGateway.sendAndWait(customerCommand);
			return customer2;
		}	
		@Override
		public boolean deleteCustomerDetails(int id) {
			Customer customer=repository.findById(id).orElseThrow(null);
			if(customer==null) {
				return false;
			}
			repository.delete(customer);
			CustomerDeleteCommand customerCommand = CustomerDeleteCommand.builder()
						.id(customer.getId())
						.uid(UUID.randomUUID().toString())
						.build();
			commandGateway.sendAndWait(customerCommand);
			return true;
		}
		private void addUser(UserDTO userDto) {
			try {
				String uriEndPoint = "http://BankApp-AuthenticationService/auth/add";
				String jsonData = new ObjectMapper().writeValueAsString(userDto);
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, headers);
				restTemplate.postForObject(uriEndPoint, httpEntity, UserDTO.class);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
}