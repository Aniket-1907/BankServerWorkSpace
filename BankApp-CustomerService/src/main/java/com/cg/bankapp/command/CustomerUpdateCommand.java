package com.cg.bankapp.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerUpdateCommand {

	@TargetAggregateIdentifier
	private int id;
	private String uid;
	private String firstName;
	private String lastName;
}
