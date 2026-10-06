package com.cg.bankapp.config;

import org.axonframework.common.jdbc.PersistenceExceptionResolver;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.axonframework.serialization.upcasting.event.EventUpcasterChain;
import org.axonframework.springboot.util.jpa.ContainerManagedEntityManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomConfig {
	
	@Autowired
	private TransactionManager transactionManager;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public EntityManagerProvider getEntityManagerProvider() {
		return new ContainerManagedEntityManagerProvider();
	}
	
	@Bean
	public TokenStore tokenStore(EntityManagerProvider entityManagerProvider) {
		return JpaTokenStore
				.builder()
				.entityManagerProvider(entityManagerProvider)
				.serializer(JacksonSerializer.defaultSerializer())
				.build();

	}
	
	@Bean
	public EventStorageEngine eventStorageEngine(
		Serializer serializer,
		PersistenceExceptionResolver persistenceExceptionResolver,
		Serializer eventSerializer,
		EntityManagerProvider entityManagerProvider,
		TransactionManager transactionManager
	) {
		
		return JpaEventStorageEngine
				.builder()
				.snapshotSerializer(serializer)
				.persistenceExceptionResolver(persistenceExceptionResolver)
				.eventSerializer(eventSerializer)
				.entityManagerProvider(entityManagerProvider)
				.transactionManager(transactionManager)
				.build();
		
	}
	
	@Bean
	public EventUpcasterChain eventUpcaster() {
		return new EventUpcasterChain();
	}
	
}
