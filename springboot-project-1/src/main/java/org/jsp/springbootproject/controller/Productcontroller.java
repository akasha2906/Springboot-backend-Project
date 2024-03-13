package org.jsp.springbootproject.controller;

import java.util.List;

import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.model.Product;
import org.jsp.springbootproject.service.Productservice;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
@CrossOrigin
public class Productcontroller {
	@Autowired
	private Productservice pservice;
	
	@PostMapping("/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Responsestructure<Product>> save(@RequestBody Product p ,@PathVariable int id)
	{
		return pservice.save(p,id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Responsestructure<Product>> update(@RequestBody Product p ,@PathVariable int id)
	{
		return pservice.Update(p,id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Responsestructure<String>> delete( @PathVariable int id) {
		return pservice.delete(id);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Responsestructure<Product>> findbyid(@PathVariable int id) {
		return pservice.findbyid(id);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<List<Product>>> findall() {
		return pservice.findall();
	}
	
	@GetMapping("/bymid/{id}")
	public ResponseEntity<Responsestructure<List<Product>>> productbymid(@PathVariable int id) {
		return pservice.bymid(id);
	}
	

}
