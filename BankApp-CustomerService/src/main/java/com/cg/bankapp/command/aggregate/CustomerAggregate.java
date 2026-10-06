package com.cg.bankapp.command.aggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.cg.bankapp.command.CustomerCreateCommand;
import com.cg.bankapp.command.CustomerDeleteCommand;
import com.cg.bankapp.command.CustomerUpdateCommand;
import com.cg.bankapp.command.events.CustomerCreateEvent;
import com.cg.bankapp.command.events.CustomerDeleteEvent;
import com.cg.bankapp.command.events.CustomerUpdateEvent;
import static org.axonframework.modelling.command.AggregateLifecycle.markDeleted;

import lombok.extern.slf4j.Slf4j;

@Aggregate
@Slf4j
public class CustomerAggregate {
	@AggregateIdentifier
	private String uid;
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	
	@CommandHandler
	public  CustomerAggregate(CustomerCreateCommand customerCommand) {
		CustomerCreateEvent customerCreateEvent = new CustomerCreateEvent();
		System.out.println(customerCommand);
		BeanUtils.copyProperties(customerCommand	, customerCreateEvent);
		AggregateLifecycle.apply(customerCreateEvent);
	}
	@EventSourcingHandler
	public void customerEventSourcingHandler(CustomerCreateEvent customerCreateEvent) {
		this.id=customerCreateEvent.getId();
		this.uid =customerCreateEvent.getUid();
		this.firstName= customerCreateEvent.getFirstName();
		this.lastName = customerCreateEvent.getLastName();
		this.username=customerCreateEvent.getUsername();
	}
	@CommandHandler
	public  CustomerAggregate(CustomerUpdateCommand customerCommand) {
		CustomerUpdateEvent customerUpdateEvent = new CustomerUpdateEvent();
		BeanUtils.copyProperties(customerCommand	, customerUpdateEvent);
		AggregateLifecycle.apply(customerUpdateEvent);
	}
	
	
	@EventSourcingHandler
	public void customerEventSourcingHandler(CustomerUpdateEvent customerUpdateEvent) {
		this.id=customerUpdateEvent.getId();
		this.uid =customerUpdateEvent.getUid();
		this.firstName= customerUpdateEvent.getFirstName();
		this.lastName = customerUpdateEvent.getLastName();
		
	}
	
	@CommandHandler
	public  CustomerAggregate(CustomerDeleteCommand customerCommand) {
		CustomerDeleteEvent customerDeleteEvent = new CustomerDeleteEvent();
		BeanUtils.copyProperties(customerCommand	, customerDeleteEvent);
		AggregateLifecycle.apply(customerDeleteEvent);
	}
	@EventSourcingHandler
	public void customerEventSourcingHandler(CustomerDeleteEvent customerDeleteEvent) {
		this.id=customerDeleteEvent.getId();
		this.uid =customerDeleteEvent.getUid();
		markDeleted();
	}
}