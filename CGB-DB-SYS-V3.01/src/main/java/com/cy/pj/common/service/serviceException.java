package com.cy.pj.common.service;

public class serviceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2749058521552616967L;

	public serviceException (String message) {
		super(message);
	}
	
	public serviceException (Throwable cause) {
		super(cause);
	}
	
	
	
}
