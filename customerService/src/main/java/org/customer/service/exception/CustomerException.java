package org.customer.service.exception;


public class CustomerException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8314961824434735672L;


	public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CustomerException(String message) {
		super(message);
		
	}

	public CustomerException(Throwable cause) {
		super(cause);
		
	}
	
	

}
