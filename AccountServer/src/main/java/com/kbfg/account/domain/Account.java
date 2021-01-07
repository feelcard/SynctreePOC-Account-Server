package com.kbfg.account.domain;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "account_info")
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4053499046316420285L;
	
	@Id
	String id;
	String accountNumber;
	String password;
	String createDate;
	String suspensionDate;
	String suspensionYn;
	long balance;
	String accountType;
	String ci;
   
	@OneToMany(mappedBy = "account")
	List<TradingHistory> tradingList;
}
