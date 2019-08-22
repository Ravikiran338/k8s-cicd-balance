package com.bank.trans.repository;





import com.bank.trans.model.Account;

import reactor.core.publisher.Mono;

public interface BalanceService {

	Mono<Account> getBalanceByAccountNo(String accountnumber);


}
