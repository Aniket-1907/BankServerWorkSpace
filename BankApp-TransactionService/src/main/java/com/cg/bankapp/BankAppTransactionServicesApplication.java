package com.cg.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//(scanBasePackages = {"org.axonframework.eventhandling.tokenstore.jpa" , "org.axonframework.modelling.saga.repository.jpa","org.axonframework.eventsourcing.eventstore.jpa","com.cg.bankapp"})
@EnableDiscoveryClient
public class BankAppTransactionServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankAppTransactionServicesApplication.class, args);
	}
}