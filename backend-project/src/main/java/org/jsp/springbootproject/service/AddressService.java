package org.jsp.springbootproject.service;

import java.util.Optional;

import org.jsp.springbootproject.dao.AddressDao;
import org.jsp.springbootproject.dto.Address;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.exception.IdNotFoundException;
import org.jsp.springbootproject.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<Responsestructure<Address>> addAddress(Address a) {
		Responsestructure<Address> structure=new Responsestructure<>();
		structure.setMessage("Admin saved successfully....");
		structure.setData(dao.saveAddress(a));
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<Responsestructure<Address>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Address>> updateAddress(Address a){
		Optional<Address> add=dao.findById(a.getId());
		Responsestructure<Address> structure=new Responsestructure<>();
		if(add.isPresent()) {
			Address ad=add.get();
			ad.setStreet(a.getStreet());
			ad.setCity(a.getCity());
			ad.setLandmark(a.getLandmark());
			ad.setBuilding_name(a.getBuilding_name());
			ad.setState(a.getState());
			ad.setCountry(a.getCountry());
			ad.setPincode(a.getPincode());
			structure.setMessage("Admin saved successfully....");
			structure.setData(dao.saveAddress(a));
			structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<Responsestructure<Address>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<Responsestructure<Address>> findById(int id){
		Optional<Address> add=dao.findById(id);
		Responsestructure<Address> structure=new Responsestructure<>();
		if(add.isPresent()) {
			structure.setMessage("Address found.....");
			structure.setData(add.get());
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<Responsestructure<Address>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<Responsestructure<Address>> verify(String state, int pincode){
		Optional<Address> add=dao.verify(state, pincode);
		Responsestructure<Address> structure=new Responsestructure<>();
		if(add.isPresent()) {
			structure.setMessage("Address found.....");
			structure.setData(add.get());
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<Responsestructure<Address>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
}


