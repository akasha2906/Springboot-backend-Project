package org.jsp.springbootproject.controller;



import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.model.User;
import org.jsp.springbootproject.service.Userservice;
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
@RequestMapping("/users")
public class Usercontroller {
	@Autowired
	private Userservice uservice;

	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Responsestructure<User>> save(@RequestBody User m,HttpServletRequest request) {
		return uservice.save(m,request);
	}


	@PutMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Responsestructure<User>> update(@RequestBody User m) {
		return uservice.update(m);
	}
	
	@GetMapping("/verify-user")
	public ResponseEntity<Responsestructure<String>> verify(@RequestParam String token)
	{
		return uservice.activate(token);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Responsestructure<User>> findbyid(@PathVariable int id)
	{
		return uservice.findbyid(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Responsestructure<String>> delete (@PathVariable int id)
	{
		return uservice.delete(id);
	}
	
	@PostMapping("/userbyphone")
	public ResponseEntity<Responsestructure<User>> verify(@RequestParam long phone,@RequestParam String password)
	{
		return uservice.verify(phone,password);
	}
	
	@GetMapping("/verifybyemail")
	public ResponseEntity<Responsestructure<User>> verify(@RequestParam String email,@RequestParam String password)
	{
		return uservice.verify(email,password);
	}

}
