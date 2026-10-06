package com.cg.bankapp.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerCreateCommand {
	@TargetAggregateIdentifier
	private String uid;
	private int id;
	private String firstName;
	private String lastName;
	private String username;
}
