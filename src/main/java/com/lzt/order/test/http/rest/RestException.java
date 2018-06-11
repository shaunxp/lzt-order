package com.lzt.order.test.http.rest;

import java.io.IOException;

/**
 * Signals an exception in the REST
 *
 */
public class RestException extends IOException {

    private static final long serialVersionUID = -4007999999227115865L;

    /**
     * Constructs a new exception with null as its detail message.
     */
    public RestException() {
        super();
    }
    
    /**
     * Constructs a new exception with the specified detail message. 
     *
     * @param   message   the detail message. 
     */
    public RestException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param  cause the cause is the throwable that caused this throwable to get thrown.
     */    
    public RestException(Throwable cause) {
        initCause(cause);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param  message the detail message
     * @param  cause the cause is the throwable that caused this throwable to get thrown.
     */  
    public RestException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
}
