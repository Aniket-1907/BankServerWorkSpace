package com.cg.bankapp.command.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.bankapp.command.entities.Customer;


public interface CustomerCommandRepository extends JpaRepository<Customer, Integer>{
	

}