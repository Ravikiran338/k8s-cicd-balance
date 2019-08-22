/**
 * 
 */
package com.bank.trans.util;

import com.bank.trans.model.Status;

/**
 * @author mn259
 *
 */
public class BalanceServiceUtil {
	
	private static BalanceServiceUtil balanceServiceUtil = null;

	private BalanceServiceUtil() {

	}
	public static BalanceServiceUtil getInstance() {
		if (balanceServiceUtil == null){
			balanceServiceUtil = new BalanceServiceUtil();
		}
		return balanceServiceUtil;
	}
	
	/**
	 * @param statusCode
	 * @param statusDesc
	 */
	public Status prepareStatus(String statusCode,String statusDesc) {
		Status status = new Status();
		status.setStatusCode(statusCode);
		status.setStatusDesc(statusDesc);
		return status;
	} 
}
