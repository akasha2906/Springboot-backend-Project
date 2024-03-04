package org.jsp.springbootproject.controller;

import java.util.List;

import org.jsp.springbootproject.dto.Branch;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.service.Branchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping(value="/Branch")
public class Branchcontroller {
	@Autowired
	private Branchservice service;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Responsestructure<Branch> saveBranch(@RequestBody Branch b) {
	  return service.saveBranch(b);
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Branch>> updateBranch(@RequestBody Branch b) {
	  return service.updateBranch(b);
		
	}
	
	@GetMapping
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public Responsestructure<Branch> Fetchall() {
	return service.Fetchall();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Responsestructure<Branch>> Fetchbyid(@PathVariable(name="id") int id) {
	return service.Fetchbyid(id);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Responsestructure<String>> deleteBranch( int id) {
	return service.deleteBranch(id);
	}
	
	@PostMapping("/verifybyphone")
	public Branch verifybyphone(@RequestParam long phone,@RequestParam String email) {
		return service.verifybyphone(phone, email);
			
	}
	@PostMapping("/verifybyemail")
	public Branch verifybyemail(@RequestParam String email,@RequestParam String name) {
	return service.verifybyemail(email, name);
			
	}
	@GetMapping("/name/{name}")
	public List<Branch> findbyname(@PathVariable String name){
		return service.findbyname(name);
		
	}
}