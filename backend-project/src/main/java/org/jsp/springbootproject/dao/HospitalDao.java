package org.jsp.springbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.dto.Hospital;
import org.jsp.springbootproject.repo.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepository repository;
	
	public Hospital saveHospital(Hospital hospital) {
		return repository.save(hospital);
	}
	
	public Hospital updateHospital(Hospital hospital) {
		return repository.save(hospital);
	}
	
	public Optional<Hospital> findById(int id){
		return repository.findById(id);
	}
	
	public List<Hospital> findAll(){
		return repository.findAll();
	}
	
	public boolean deleteById(int id) {
		Optional<Hospital> rechospital=repository.findById(id);
		if(rechospital.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
