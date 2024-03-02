package org.jsp.springbootproject.service;




import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.dao.Admindao;
import org.jsp.springbootproject.dto.Admin;
import org.jsp.springbootproject.dto.Responsestructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class Adminservice {
	
	@Autowired
	private Admindao dao;
	
	
	public Responsestructure<Admin> saveAdmin( Admin m) {
		Responsestructure<Admin> structure=new Responsestructure<Admin>();
		structure.setData(dao.saveAdmin(m));
		structure.setMessage("Admin Saved");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return structure;
	}
	
	public ResponseEntity<Responsestructure<Admin>> updateAdmin(Admin m) {
		Optional<Admin> recAdmin=dao.findbyid(m.getId());
		Responsestructure<Admin> structure=new Responsestructure<Admin>();
		if(recAdmin.isPresent())
		{
			Admin db=recAdmin.get();
			db.setName(m.getName());
			db.setEmail(m.getEmail());
			db.setPhone(m.getPhone());
			db.setPassword(m.getPassword());
			structure.setMessage("Admin Updated Sucessfully");
			structure.setData(dao.saveAdmin(m));
			structure.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<Responsestructure<Admin>>(structure,HttpStatus.ACCEPTED);
		}else {
//		     throw new IDNOTFOUNDException();
			return null;
		}
		
	}

	public Responsestructure<Admin> Fetchall() {
		Responsestructure<Admin> structure=new Responsestructure<>();
		structure.setMessage("Admin List");
		structure.setData((Admin) dao.findAll());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return structure ;
	}
	
	public ResponseEntity<Responsestructure<Admin>> Fetchbyid(int id) {
		Optional<Admin> recAdmin=dao.findbyid(id);
		Responsestructure<Admin> structure=new Responsestructure<Admin>();
		
		if(recAdmin.isPresent()) {
			structure.setMessage("Admin Found With The Id:");
			structure.setData(recAdmin.get());
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<Responsestructure<Admin>>(structure,HttpStatus.OK);
		}else {
//			throw new IDNOTFOUNDException();
			return null;
		}
	}
	
	
	public ResponseEntity<Responsestructure<String>> deleteAdmin( int id) {
		Optional<Admin> recAdmin=dao.findbyid(id);
		Responsestructure<String> structure=new Responsestructure<>();
		if(recAdmin.isPresent()) {
			structure.setMessage("Merchnat Deleted");
			structure.setData("Admin Deleted");
			structure.setStatuscode(HttpStatus.OK.value());
			dao.deletebyid(id);
			return new ResponseEntity<Responsestructure<String>>(structure,HttpStatus.OK);
		}else {
//			throw new IDNOTFOUNDException();
			return null;
		}
	}
	
	public Admin verifybyphone( long phone, String password) {
		Optional<Admin> recAdmin=dao.verify(phone, password);
		if(recAdmin.isPresent()) {
			return recAdmin.get();
		}else {
//			throw new InvalidCreditianlsException("Invalid Phone number Or Password");
			return null;

		}
			
	}
	public Admin verifybyemail( String email, String password) {
		Optional<Admin> recAdmin=dao.verify(email, password);
		
		if(recAdmin.isPresent()) {
			return recAdmin.get();
		}else {
//			throw new InvalidCreditianlsException("Invalid Email Or Password");
			return null;
		}
			
	}
	public List<Admin> findbyname( String name){
		return dao.verify(name);
		
	}

	

}
