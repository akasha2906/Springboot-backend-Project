package org.jsp.springbootproject.exception;

import org.jsp.springbootproject.dto.Responsestructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MerchantException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value=InvalidCredentialException.class)
	public ResponseEntity<Responsestructure<String>> verifyehandler(InvalidCredentialException exception) {
		Responsestructure<String> m=new Responsestructure<>();
		m.setBody(exception.getMessage());
		m.setMessage("invalid");
		m.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(m,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=IdNotFoundException.class)
	public ResponseEntity<Responsestructure<String>> verifyehandler(IdNotFoundException exception) {
		Responsestructure<String> m=new Responsestructure<>();
		m.setBody(exception.getMessage());
		m.setMessage("Id not found");
		m.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(m,HttpStatus.NOT_FOUND);
	}

}
