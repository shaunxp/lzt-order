package com.lzt.order.test.http.rest;

/**
 * ResenderHandler Register
 */
public class RestResendAdapter {
	private static RestResendHandler HANDLER = null;
	
	/**
	 * if handler==null or not special exception just return false and throw exception directly, else resend message
	 * @param method rest method
	 * @param serverUrl url
	 * @param clientData send data
	 * @return boolean directly throw exception
	 * @throws RestException 
	 */
	public static boolean dealWithException(Exception e, String method, String serverUrl, String clientData) throws RestException {
		if (null == HANDLER) {
			return false;
		}
		return HANDLER.dealWithException(e, method, serverUrl, RestCodec.decodeData(clientData));
	}
	
	/**
	 * register resendHandler 4 deal exception
	 * @param handler
	 */
	public static void registerRestResendHandler(RestResendHandler handler) {
		if (null == HANDLER) {
			HANDLER = handler;
		}		
	}
}
