package com.cg.bankapp.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDeleteCommand {
	@TargetAggregateIdentifier
	private String uid;
	private int id;
}
