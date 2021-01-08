package com.kbfg.card.domain;

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
public class PaymentHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6674031139840679665L;
	
	@Id
	String id;
	String paymentDate;
	String product;
	@ManyToOne
	@JoinColumn(name="card_id")
	Card card;
}
