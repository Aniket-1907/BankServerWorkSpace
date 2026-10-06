package com.cg.bankapp.command.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.command.entities.Transaction;


public interface TransactionCommandRepository extends JpaRepository<Transaction, Integer>{
	

}