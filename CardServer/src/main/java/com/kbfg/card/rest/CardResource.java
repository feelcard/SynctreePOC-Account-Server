package com.kbfg.card.rest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kbfg.card.domain.CardRequestDTO;
import com.kbfg.card.service.CardService;

@RestController("/")
public class CardResource {

	@Autowired
	CardService CardService;
	
	@PostMapping(value="/Card", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findbyCi(@RequestBody CardRequestDTO requestdto){
		System.out.println(requestdto.getCi());
		return new ResponseEntity<>(CardService.findbyCi(requestdto.getCi()),HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<>(CardService.findAll(),HttpStatus.OK);
		
	}
	
}
