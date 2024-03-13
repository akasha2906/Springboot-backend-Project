package org.jsp.springbootproject.exception;

public class IdNotFoundException extends RuntimeException{
	public IdNotFoundException() {
		super();
	}
	
	public IdNotFoundException(String msg) {
		super(msg);
	}

}
