package org.jsp.springbootproject.controller;

import java.util.List;

import org.jsp.springbootproject.dto.Hospital;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hospitals")
public class HospitalController {

	@Autowired	
	private HospitalService service;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return service.saveHospita(hospital);
	}
	@PutMapping
	public ResponseEntity<Responsestructure<Hospital>> updateHospital(@RequestBody Hospital hospital) {
		return service.updateHospital(hospital);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Responsestructure<Hospital>> findById(@PathVariable(name= "id")int id){
		return service.findById(id);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Responsestructure<String>> deleteById(@PathVariable(name="id")int id){
		return service.deleteById(id);
	}
	@GetMapping
	public Responsestructure<List<Hospital>> findAll(){
		return service.findAll();
	}

}
