package com.cg.bankapp.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.query.entities.Account;

public interface AccountQueryRepository extends JpaRepository<Account, Integer> {}
