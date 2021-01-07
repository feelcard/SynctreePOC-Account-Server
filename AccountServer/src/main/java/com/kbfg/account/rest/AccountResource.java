package com.kbfg.account.rest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kbfg.account.domain.AccountRequestDTO;
import com.kbfg.account.service.AccountService;

@RestController("/")
public class AccountResource {

	@Autowired
	AccountService accountService;
	
	@PostMapping(value="/account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findbyCi(@RequestBody AccountRequestDTO requestdto){
		System.out.println(requestdto.getCi());
		return new ResponseEntity<>(accountService.findbyCi(requestdto.getCi()),HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<>(accountService.findAll(),HttpStatus.OK);
		
	}
	
}
