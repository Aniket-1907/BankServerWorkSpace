package com.cg.bankapp.command.events;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.command.repositories.AccountCommandRepository;
import com.cg.bankapp.query.entities.Account;
import com.cg.bankapp.query.repositories.AccountQueryRepository;

@Component
@ProcessingGroup("account")
public class AccountEventHandler {
	
	@Autowired
	private AccountQueryRepository accountQueryRepository;
	
	@Autowired
	private AccountCommandRepository accountCommandRepository;
	
	@EventHandler
	Account on(AccountCreateEvent accountCreateEvent) {
		
		Account account = new Account();
		BeanUtils.copyProperties(accountCreateEvent, account);
		return accountQueryRepository.save(account);

	}
	
	@EventHandler
	Account on(AccountUpdateEvent accountUpdateEvent) {
		
		Account account = new Account();
		BeanUtils.copyProperties(accountUpdateEvent, account);
		
		return accountQueryRepository.save(account);
		
	}
	
	@EventHandler
	void on(AccountUpdateRollbackEvent accountUpdateRollbackEvent) {
		
		com.cg.bankapp.command.entities.Account account = accountCommandRepository
				.findById(accountUpdateRollbackEvent.getAccountNumber())
				.get();
		
		if (accountUpdateRollbackEvent.getTransaction_type().equalsIgnoreCase("debit")) {
			account.setBalance(account.getBalance() + accountUpdateRollbackEvent.getAmount());
		} else {
			account.setBalance(account.getBalance() - accountUpdateRollbackEvent.getAmount());
		}
		
		accountCommandRepository.save(account);
		
	}

}
