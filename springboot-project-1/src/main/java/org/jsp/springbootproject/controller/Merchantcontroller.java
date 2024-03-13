package org.jsp.springbootproject.controller;


import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.model.Merchant;
import org.jsp.springbootproject.service.Merchantsercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/merchants")
public class Merchantcontroller {
	@Autowired
	private Merchantsercice mservice;

	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Responsestructure<Merchant>> save(@RequestBody Merchant m ,HttpServletRequest request) {
		return mservice.save(m,request);
	}
	
	@GetMapping("/verify-merchant")
	public ResponseEntity<Responsestructure<String>> verify(@RequestParam String token)
	{
		return mservice.activate(token);
	}

	@PutMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Responsestructure<Merchant>> update(@RequestBody Merchant m) {
		return mservice.update(m);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Responsestructure<Merchant>> findbyid (@PathVariable int id)
	{
		return mservice.findbyid(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Responsestructure<String>> delete(@PathVariable int id)
	{
		return mservice.delete(id);
	}
	
	@PostMapping("/verifybyphone")
	public ResponseEntity<Responsestructure<Merchant>> verify(@RequestParam long phone,@RequestParam String password)
	{
		return mservice.verify(phone,password);
	}
	
	@PostMapping("/verifybyemail")
	public ResponseEntity<Responsestructure<Merchant>> verify(@RequestParam String email,@RequestParam String password)
	{
		return mservice.verify(email,password);
	}

}
