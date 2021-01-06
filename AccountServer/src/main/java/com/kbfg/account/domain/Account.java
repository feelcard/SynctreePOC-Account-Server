package com.kbfg.account.domain;



import java.util.List;
import lombok.Data;

//@Entity
@Data
public class Account {
	String id;
	String accountNumber;
	String password;
	String createDate;
	String suspensionDate;
	String suspensionYn;
	long balance;
	String accountType;
	String ci;
   
	//@ManyToOne(targetEntity = TradingHistory.class)
	List<TradingHistory> tradingList;
}
