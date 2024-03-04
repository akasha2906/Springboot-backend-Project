package org.jsp.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.dao.HospitalDao;
import org.jsp.springbootproject.dto.Hospital;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;
	
	public ResponseEntity<Responsestructure<Hospital>> saveHospita(Hospital hospital){
		Responsestructure<Hospital> structure=new Responsestructure<>();
		hospital = dao.saveHospital(hospital);
		structure.setData(hospital);
		structure.setMessage("Hospital saved");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<Responsestructure<Hospital>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Hospital>> updateHospital(Hospital hospital){
		Optional<Hospital> rechospital=dao.findById(hospital.getId());
		Responsestructure<Hospital> structure=new Responsestructure<>();
		if(rechospital.isPresent()) {
			Hospital dbhospital=rechospital.get();
			dbhospital.setName(hospital.getName());
			dbhospital.setGst_number(hospital.getGst_number());
			dbhospital.setFounder(hospital.getFounder());
			dbhospital.setYear_of_estb(hospital.getYear_of_estb());
			structure.setData(dao.saveHospital(hospital));
			structure.setMessage("Hospital updated");
			structure.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<Responsestructure<Hospital>>(structure,HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
		
	}
	
	public ResponseEntity<Responsestructure<Hospital>> findById(int id){
		Optional<Hospital> rechospital=dao.findById(id);
		Responsestructure<Hospital> structure=new Responsestructure<>();
		if(rechospital.isPresent()) {
			structure.setMessage("Hospital Id found");
			structure.setData(rechospital.get());
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<Responsestructure<Hospital>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<Responsestructure<String>> deleteById(int id){
		Optional<Hospital> rechospital=dao.findById(id);
		Responsestructure<String> structure=new Responsestructure<>();
		if(rechospital.isPresent()) {
			structure.setMessage("Hospital found");
			structure.setData("Hospital deleted");
			structure.setStatuscode(HttpStatus.OK.value());
			dao.deleteById(id);
			return new ResponseEntity<Responsestructure<String>>(structure,HttpStatus.OK);
		}
		structure.setData("Cannot delete Hospital because invalid id");
		structure.setMessage("Hospital not found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	public Responsestructure<List<Hospital>> findAll(){
		Responsestructure<List<Hospital>> structure=new Responsestructure<>();
		structure.setMessage("Hospital details");
		structure.setData(dao.findAll());
		structure.setStatuscode(HttpStatus.OK.value());
		return structure;
	}


}
