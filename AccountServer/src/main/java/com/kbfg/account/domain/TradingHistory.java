package com.kbfg.account.domain;

import lombok.Data;

//@Entity
@Data
public class TradingHistory {
	String id;
	String accountId;
	String tradingDate;
	//@OneToMany(mappedBy = "tradingList")
	Account account;
}
