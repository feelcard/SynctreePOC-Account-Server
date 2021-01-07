package com.kbfg.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kbfg.account.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	List<Account> findByCi(String ci);
}
