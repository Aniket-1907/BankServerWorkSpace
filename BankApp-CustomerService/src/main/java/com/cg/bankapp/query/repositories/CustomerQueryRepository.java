package com.cg.bankapp.query.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.query.entites.Customer;
public interface CustomerQueryRepository extends JpaRepository<Customer, Integer>{
	

}