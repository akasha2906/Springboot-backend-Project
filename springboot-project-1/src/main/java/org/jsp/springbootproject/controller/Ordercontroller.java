package org.jsp.springbootproject.controller;

import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.model.Orderdetails;
import org.jsp.springbootproject.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderd")
public class Ordercontroller {
	@Autowired
	private Orderservice oservice;
	
	@PostMapping("/{pid}/{uid}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Responsestructure<Orderdetails>> save(@RequestBody Orderdetails orderd)
	{
		return oservice.save(orderd);
	}

}
