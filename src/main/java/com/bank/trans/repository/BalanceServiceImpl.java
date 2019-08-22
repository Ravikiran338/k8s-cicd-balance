package com.bank.trans.repository;

import org.springframework.stereotype.Service;

import com.bank.trans.constants.BalanceQueryConstants;
import com.bank.trans.constants.BalanceServiceConstants;
import com.bank.trans.model.Account;
import com.bank.trans.util.DatabaseUtil;

import io.reactivex.Flowable;
import reactor.core.publisher.Mono;
@Service
public class BalanceServiceImpl implements BalanceService {
	
	
	
	@Override
	public Mono<Account> getBalanceByAccountNo(String accountnumber) {
		Flowable<Account> employeeFlowable =
				DatabaseUtil.getInstance().getDatabase().select(BalanceQueryConstants.SELECT_BALANCE_BY_ACCOUNT_NUMBER)
		            .parameters(accountnumber)
		            .get(
		                rs -> {
		                	Account accountManagement = new Account();
		                	accountManagement.setAccountId(rs.getInt(BalanceServiceConstants.ACCOUNT_ID));
		                	accountManagement.setCustomerId(rs.getInt(BalanceServiceConstants.CUSTOMER_ID));
		                	accountManagement.setBalance((rs.getBigDecimal(BalanceServiceConstants.BALANCE)));
		                	accountManagement.setAccountNum(rs.getString(BalanceServiceConstants.ACCOUNT_NUMBER));
		                	accountManagement.setAccountType(rs.getString(BalanceServiceConstants.ACCOUNT_TYPE));
		                	accountManagement.setActiveFlag(rs.getString(BalanceServiceConstants.ACTIVE_FLAG));
		                	accountManagement.setAccountCreatedDatetime(rs.getString(BalanceServiceConstants.ACCOUNT_CREATED_DATE_AND_TIME));
		                  return accountManagement;
		                });
		    return Mono.from(employeeFlowable);
		  }
	
	
	
}
