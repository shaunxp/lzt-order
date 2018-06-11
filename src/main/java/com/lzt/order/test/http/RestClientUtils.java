package com.lzt.order.test.http;


import com.lzt.order.test.http.rest.RestClient;
import org.apache.log4j.Logger;



public class RestClientUtils {
	private static final Logger logger = Logger.getLogger(RestClientUtils.class);

	private static RestClient restClient;

	public static String executeRestClient(String param, String url, String method) {

		String response = null;
		try {
			restClient = new RestClient(url);
			restClient.setConnectTimeout(15);
			restClient.setSocketTimeout(15);
			restClient.setMethod(method);
			restClient.setData(param);
			response = restClient.execute();

		} catch (Exception e) {
			logger.error("execute  httpClient failed", e);
			return null;
		}
		return response;
	}
}
