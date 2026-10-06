package com.cg.bankapp.command.events;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.query.entites.Customer;
import com.cg.bankapp.query.repositories.CustomerQueryRepository;

@Component
@ProcessingGroup("customer")
public class CustomerEventHandler {

	@Autowired
	private CustomerQueryRepository customerDAO;
	
	@EventHandler  
	Customer on(CustomerCreateEvent customerCreateEvent) {
		Customer customerEntity =  new Customer();
		System.out.println(customerCreateEvent);
		BeanUtils.copyProperties(customerCreateEvent, customerEntity);	
		return customerDAO.save(customerEntity);
	}
	
	@EventHandler  
	Customer on(CustomerUpdateEvent customerUpdateEvent) {
		Customer customerEntity =  new Customer();
		System.out.println(customerUpdateEvent);
		BeanUtils.copyProperties(customerUpdateEvent, customerEntity);	
		return customerDAO.save(customerEntity);
	}
	
	@EventHandler  
	public void on(CustomerDeleteEvent customerDeleteEvent) {
		Customer customerEntity =  new Customer();
		System.out.println(customerDeleteEvent);
		BeanUtils.copyProperties(customerDeleteEvent, customerEntity);	
		customerDAO.deleteById(customerDeleteEvent.getId());
		return ;
	}	
}