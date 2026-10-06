package com.cg.bankapp.command.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.command.entities.Account;

public interface AccountCommandRepository extends JpaRepository<Account, Integer> {}
