package com.kbfg.account.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "trading_history")
public class TradingHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6674031139840679665L;
	
	@Id
	String id;
	String tradingDate;
	@ManyToOne
	@JoinColumn(name="account_id")
	Account account;
}
