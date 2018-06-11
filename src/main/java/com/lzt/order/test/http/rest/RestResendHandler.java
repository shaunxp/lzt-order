package com.lzt.order.test.http.rest;

/**
 *	interface of resendHandler
 */
public interface RestResendHandler {
	
	/**
	 * check exception, resend message if necessary
	 * @param method rest method
	 * @param serverUrl url
	 * @param clientData send data
	 * @return boolean directly throw exception
	 */
	public boolean dealWithException(Exception e, String method, String serverUrl, String clientData);
	
}