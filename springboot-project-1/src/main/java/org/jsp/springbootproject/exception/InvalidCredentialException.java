package org.jsp.springbootproject.exception;

public class InvalidCredentialException extends RuntimeException{
//	
	
	public InvalidCredentialException(String msg) {
		super(msg);
	}
	
	public InvalidCredentialException() {
		super();
	}

}
