package com.cg.bankapp.query.services;
import com.cg.bankapp.exceptions.CustomerDetailsNotFoundException;
import com.cg.bankapp.query.entites.Customer;

public interface CustomerQueryService {
	Customer getCustomerDetails (int  id) throws CustomerDetailsNotFoundException;
}