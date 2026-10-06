package com.cg.bankapp.command.service;

import com.cg.bankapp.command.entities.Customer;
public interface CustomerCommandService {
	Customer addCustomerDetails(Customer customer,String password);
	Customer updateCustomerDetails(Customer customer);
	boolean deleteCustomerDetails(int id);
	
	
}