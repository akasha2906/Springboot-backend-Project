package org.jsp.springbootproject.controller;

import java.util.List;

import org.jsp.springbootproject.dto.Admin;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.service.Adminservice;
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
@RequestMapping(value="/Admin")
public class Admincontroller {
	@Autowired
	private Adminservice service;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Responsestructure<Admin> saveAdmin(@RequestBody Admin m) {
	  return service.saveAdmin(m);
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Admin>> updateAdmin(@RequestBody Admin m) {
	  return service.updateAdmin(m);
		
	}
	
	@GetMapping
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public Responsestructure<Admin> Fetchall() {
	return service.Fetchall();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Responsestructure<Admin>> Fetchbyid(@PathVariable(name="id") int id) {
	return service.Fetchbyid(id);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Responsestructure<String>> deleteAdmin( int id) {
	return service.deleteAdmin(id);
	}
	
	@PostMapping("/verifybyphone")
	public Admin verifybyphone(@RequestParam long phone,@RequestParam String password) {
		return service.verifybyphone(phone, password);
			
	}
	@PostMapping("/verifybyemail")
	public Admin verifybyemail(@RequestParam String email,@RequestParam String password) {
	return service.verifybyemail(email, password);
			
	}
	@GetMapping("/name/{name}")
	public List<Admin> findbyname(@PathVariable String name){
		return service.findbyname(name);
		
	}

}
