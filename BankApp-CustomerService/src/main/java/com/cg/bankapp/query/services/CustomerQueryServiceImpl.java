package com.cg.bankapp.query.services;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.exceptions.CustomerDetailsNotFoundException;
import com.cg.bankapp.query.GetCustomerByIdQuery;
import com.cg.bankapp.query.entites.Customer;

@Component
public class CustomerQueryServiceImpl implements CustomerQueryService{
	
		@Autowired private CommandGateway commandGateway;
		
		@Autowired private QueryGateway queryGateway;
		@Override
		public Customer getCustomerDetails(int id) throws CustomerDetailsNotFoundException {
			 return queryGateway.query(new GetCustomerByIdQuery(id), ResponseTypes.instanceOf(Customer.class)).join();
		}
		
		
	
}