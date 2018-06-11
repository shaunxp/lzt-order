package com.lzt.order.test.http.rest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;

/**
 * The client of REST. Sends the data to server and gets the data from server.
 */
public class RestClient {

	/**
	 * HTTP method constant:GET/POST/PUT/DELETE
	 */
	public static final String GET = "GET";
	public static final String POST = "POST";
	public static final String PUT = "PUT";
	public static final String DELETE = "DELETE";

	/* URL of server */
	private String serverUrl;

	/* http method : get/post/put/delete */
	private String httpMethod;

	/* the date sent to server */
	private String clientData;

	/* timeout : 2 seconds */
	private final int DEFAULT_TIMEOUT = 2;

	/* connection timeout */
	private int connectTimeout;

	/* the time to wait for data from server */
	private int socketTimeout;

	/**
	 * Constructs client with URL, method, and data
	 * 
	 * @param url
	 *            the url of server of REST
	 * @param method
	 *            method of HTTP(get/post/delete/put)
	 * @param data
	 *            data in JSON format
	 */
	public RestClient(String url, String method, String data) {
		this.serverUrl = url;
		this.httpMethod = method;
		this.clientData = data;
		this.connectTimeout = DEFAULT_TIMEOUT;
		this.socketTimeout = DEFAULT_TIMEOUT;
	}

	/**
	 * Constructs client with the specified URL
	 * 
	 * @param url
	 *            the url of server of REST
	 */
	public RestClient(String url) {
		this.serverUrl = url;
		this.httpMethod = GET;
		this.clientData = null;
		this.connectTimeout = DEFAULT_TIMEOUT;
		this.socketTimeout = DEFAULT_TIMEOUT;
	}

	/**
	 * Constructs client with the specified URL and data
	 * 
	 * @param url
	 *            the url of server of REST
	 * @param data
	 *            data in JSON format
	 */
	public RestClient(String url, String data) {
		this.serverUrl = url;
		this.httpMethod = GET;
		this.clientData = data;
		this.connectTimeout = DEFAULT_TIMEOUT;
		this.socketTimeout = DEFAULT_TIMEOUT;
	}

	/**
	 * Sets the url of server of REST
	 * 
	 * @param url
	 *            the url of server of REST
	 */
	public void setURL(String url) {
		this.serverUrl = url;
	}

	/**
	 * Sets the HTTP method
	 * 
	 * @param method
	 *            method of HTTP(get/post/delete/put)
	 */
	public void setMethod(String method) {
		this.httpMethod = method;
	}

	/**
	 * Sets the data be sent to server of REST
	 * 
	 * @param data
	 *            data will be sent to server of REST
	 */
	public void setData(String data) {
		this.clientData = data;
	}

	/**
	 * Sets the time to connect to server of REST,unit(second)
	 * 
	 * @param connectTimeout
	 *            the time to connect to server of REST
	 */
	public void setConnectTimeout(int connectTimeout) {
		if (0 < connectTimeout) {
			this.connectTimeout = connectTimeout;
		} else {

		}
	}

	/**
	 * Sets the time to wait server of REST to deal with data,unit(second)
	 * 
	 * @param socketTimeout
	 *            the time to wait server of REST to deal with data
	 */
	public void setSocketTimeout(int socketTimeout) {
		if (0 < socketTimeout) {
			this.socketTimeout = socketTimeout;
		} else {

		}
	}

	/**
	 * Sends the request to server and gets the data from server
	 * 
	 * @return data from server
	 * @throws RestException
	 *             Thrown when exception in encode, decode or connection
	 */
	public String execute() throws RestException {
		return this.execute(false);
	}

	/**
	 * resend
	 * 
	 * @param shouldResend
	 * @return data from server
	 * @throws RestException
	 */
	public String execute(boolean shouldResend) throws RestException {
		if (null == serverUrl) {
			return null;
		} else {

		}

		clientData = RestCodec.encodeData(clientData);
		String ret = httpExecute(shouldResend);
		if (null != ret) {
			ret = RestCodec.decodeData(ret);
		} else {

		}
		return ret;
	}

	/**
	 * get http client
	 * 
	 * @return http client
	 */
	private DefaultHttpClient getHttpClient() {
		DefaultHttpClient httpClient = new DefaultHttpClient();

		/* set parameters for request */
		httpClient.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "utf-8");
		if (0 < connectTimeout) {
			httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectTimeout * 1000);
		} else {
			/* do nothing */
		}
		if (0 < socketTimeout) {
			httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, socketTimeout * 1000);
		} else {
			/* do nothing */
		}
		return httpClient;
	}

	/**
	 * append data in url
	 * 
	 * @return url appended with data
	 */
	private String getURLWithData() {
		if (clientData != null) {
			if (serverUrl.endsWith("?")) {
				return serverUrl + clientData;
			} else {
				return serverUrl + "?" + clientData;
			}
		}
		return serverUrl;
	}

	/**
	 * execute request and return repsponse
	 * 
	 * @return data from server
	 * @throws RestException
	 *             rest exception
	 */
	private String httpExecute(boolean shouldResend) throws RestException {
		String ret = null;
		DefaultHttpClient httpclient = getHttpClient();
		try {
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			if (httpMethod.equalsIgnoreCase(GET)) {
				/* set the data after URL */
				HttpGet req = new HttpGet(getURLWithData());
				ret = httpclient.execute(req, responseHandler);
			} else if (httpMethod.equalsIgnoreCase(POST)) {
				HttpPost req = new HttpPost(serverUrl);
				if (null != clientData) {
					/* set the post data in the body */
					req.setEntity(new StringEntity(clientData));
				} else {

				}
				ret = httpclient.execute(req, responseHandler);
			} else if (httpMethod.equalsIgnoreCase(PUT)) {
				HttpPut req = new HttpPut(serverUrl);
				if (null != clientData) {
					/* set the put data in the body */
					req.setEntity(new StringEntity(clientData));
				} else {

				}
				ret = httpclient.execute(req, responseHandler);
			} else if (httpMethod.equalsIgnoreCase(DELETE)) {
				/* set the data after URL */
				HttpDelete req = new HttpDelete(getURLWithData());
				ret = httpclient.execute(req, responseHandler);
			} else {

			}
		} catch (ClientProtocolException e) {
			this.resendHandle(e, shouldResend);
		} catch (IOException e) {
			this.resendHandle(e, shouldResend);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), e.getCause());
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return ret;
	}

	private void resendHandle(Exception e, boolean shouldResend) throws RestException {
		if (!shouldResend || !RestResendAdapter.dealWithException(e, this.httpMethod, this.serverUrl, this.clientData)) {
			throw new RestException(e.getMessage(), e.getCause());
		}
	}

}
