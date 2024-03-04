package org.jsp.springbootproject.exception;


public class IdNotFoundException extends RuntimeException{
	public String getMessage() {
		return "Id Not Found";
	}
}
