package com.kbfg.card.domain;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "card_info")
public class Card implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4053499046316420285L;
	
	@Id
	String id;
	String cardNumber;
	String password;
	String createDate;
	String suspensionDate;
	String suspensionYn;
	String accountType;
	String ci;
   
	@OneToMany(mappedBy = "card")
	List<PaymentHistory> paymentList;
}
