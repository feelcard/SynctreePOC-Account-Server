package com.kbfg.card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kbfg.card.domain.Card;

public interface CardRepository extends JpaRepository<Card, String> {
	List<Card> findByCi(String ci);
}
