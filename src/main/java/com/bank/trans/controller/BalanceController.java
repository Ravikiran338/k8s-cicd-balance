package com.bank.trans.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.trans.model.Account;
import com.bank.trans.repository.BalanceService;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class BalanceController {
	
	@Autowired
	BalanceService balanceService;
	
	@GetMapping
	public Mono<Account> getAccountBal(@RequestParam String accountnumber) {
		return balanceService.getBalanceByAccountNo(accountnumber);
	}	

}
