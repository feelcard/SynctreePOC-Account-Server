package com.kbfg.account.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kbfg.account.domain.Account;
import com.kbfg.account.repository.AccountRepository;

@Service
public class AccountService {
	
	@Inject
	AccountRepository accountRepository;
	
	public List<Account> findbyCi(String ci){
		return accountRepository.findByCi(ci);
	}
	
	public List<Account> findAll(){
		return accountRepository.findAll();
	}

}
