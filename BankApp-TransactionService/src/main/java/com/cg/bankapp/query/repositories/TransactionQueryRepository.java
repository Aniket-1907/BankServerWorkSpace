package com.cg.bankapp.query.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.query.entites.Transaction;


public interface TransactionQueryRepository extends JpaRepository<Transaction, Integer>{
	public List<Transaction> findAllByAccountNumber(int accountNumber);

}