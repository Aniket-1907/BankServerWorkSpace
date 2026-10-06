package com.cg.bankapp.query.projections;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.query.entites.Customer;
import com.cg.bankapp.exceptions.CustomerDetailsNotFoundException;
import com.cg.bankapp.query.GetCustomerByIdQuery;
import com.cg.bankapp.query.repositories.CustomerQueryRepository;

@Component
public class CustomerProjection {

	@Autowired
	CustomerQueryRepository customerDAO;
	
	@QueryHandler
	public Customer handelGetCustomerQuery(GetCustomerByIdQuery getCustomerByIdQuery) throws CustomerDetailsNotFoundException {
		return customerDAO.findById(getCustomerByIdQuery.getId()).orElseThrow(()->new CustomerDetailsNotFoundException("Customer Details Not found for Id :-  "+getCustomerByIdQuery.getId()));
	}
}