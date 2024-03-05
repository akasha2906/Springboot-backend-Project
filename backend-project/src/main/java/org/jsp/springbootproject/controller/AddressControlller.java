package org.jsp.springbootproject.controller;

import org.jsp.springbootproject.dto.Address;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/address")
public class AddressControlller {
		@Autowired
		private AddressService service;

		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		public ResponseEntity<Responsestructure<Address>> addAddress(@RequestBody Address a) {
			return service.addAddress(a);
		}

		@PutMapping
		public ResponseEntity<Responsestructure<Address>> updateAddress(@RequestBody Address a) {
			return service.updateAddress(a);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Responsestructure<Address>> findById(@PathVariable(name = "id") int id) {
			return service.findById(id);
		}

		@PostMapping("/verify-by-state")
		public ResponseEntity<Responsestructure<Address>> verifyBystate(@RequestParam String state,
				@RequestParam int pincode) {
			return service.verify(state, pincode);
		}
	}


