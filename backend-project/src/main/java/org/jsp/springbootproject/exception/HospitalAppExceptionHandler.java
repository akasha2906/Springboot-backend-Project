package org.jsp.springbootproject.exception;

import org.jsp.springbootproject.dto.Responsestructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HospitalAppExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<Responsestructure<String>> handleIdNotFoundException(IdNotFoundException exception) {
		Responsestructure<String> structure = new Responsestructure<String>();
		structure.setData("ID NOT FOUND");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		return new ResponseEntity<Responsestructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
