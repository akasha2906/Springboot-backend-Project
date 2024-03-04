package org.jsp.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.dao.Branchdao;
import org.jsp.springbootproject.dto.Branch;
import org.jsp.springbootproject.dto.Responsestructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Branchservice {
	@Autowired
	private Branchdao dao;
	
	
	public Responsestructure<Branch> saveBranch( Branch b) {
		Responsestructure<Branch> structure=new Responsestructure<Branch>();
		structure.setData(dao.saveBranch(b));
		structure.setMessage("Branch Saved");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return structure;
	}
	
	public ResponseEntity<Responsestructure<Branch>> updateBranch(Branch b) {
		Optional<Branch> recBranch=dao.findbyid(b.getId());
		Responsestructure<Branch> structure=new Responsestructure<Branch>();
		if(recBranch.isPresent())
		{
			Branch db=recBranch.get();
			db.setName(b.getName());
			db.setEmail(b.getEmail());
			db.setPhone(b.getPhone());
			structure.setMessage("Branch Updated Sucessfully");
			structure.setData(dao.saveBranch(b));
			structure.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<Responsestructure<Branch>>(structure,HttpStatus.ACCEPTED);
		}else {
//		     throw new IDNOTFOUNDException();
			return null;
		}
		
	}

	public Responsestructure<Branch> Fetchall() {
		Responsestructure<Branch> structure=new Responsestructure<>();
		structure.setMessage("Branch List");
		structure.setData((Branch) dao.findAll());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return structure ;
	}
	
	public ResponseEntity<Responsestructure<Branch>> Fetchbyid(int id) {
		Optional<Branch> recBranch=dao.findbyid(id);
		Responsestructure<Branch> structure=new Responsestructure<Branch>();
		
		if(recBranch.isPresent()) {
			structure.setMessage("Branch Found With The Id:");
			structure.setData(recBranch.get());
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<Responsestructure<Branch>>(structure,HttpStatus.OK);
		}else {
//			throw new IDNOTFOUNDException();
			return null;
		}
	}
	
	
	public ResponseEntity<Responsestructure<String>> deleteBranch( int id) {
		Optional<Branch> recBranch=dao.findbyid(id);
		Responsestructure<String> structure=new Responsestructure<>();
		if(recBranch.isPresent()) {
			structure.setMessage("Branch Deleted");
			structure.setData("Branch Deleted");
			structure.setStatuscode(HttpStatus.OK.value());
			dao.deletebyid(id);
			return new ResponseEntity<Responsestructure<String>>(structure,HttpStatus.OK);
		}else {
//			throw new IDNOTFOUNDException();
			return null;
		}
	}
	
	public Branch verifybyphone( long phone, String email) {
		Optional<Branch> recBranch=dao.verify(phone, email);
		if(recBranch.isPresent()) {
			return recBranch.get();
		}else {
//			throw new InvalidCreditianlsException("Invalid Phone number Or email");
			return null;

		}
			
	}
	public Branch verifybyemail( String email, String name) {
		Optional<Branch> recBranch=dao.verify(email, name);
		
		if(recBranch.isPresent()) {
			return recBranch.get();
		}else {
//			throw new InvalidCreditianlsException("Invalid Email Or Password");
			return null;
		}
			
	}
	public List<Branch> findbyname( String name){
		return dao.verify(name);
		
	}

	

}
