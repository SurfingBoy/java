package com.su.exception;

/**
 * 库存不足
 * @author Administrator
 *
 */
public class AppointException extends RuntimeException{

	public AppointException(String message) {
		super(message);
	}
	
	public AppointException(String message,Throwable cause) {
		super(message,cause);
	}
}
