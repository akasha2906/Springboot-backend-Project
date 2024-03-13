package org.jsp.springbootproject.service;

import java.util.Optional;

import org.jsp.springbootproject.dao.Merchantdao;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.exception.IdNotFoundException;
import org.jsp.springbootproject.exception.InvalidCredentialException;
import org.jsp.springbootproject.model.Merchant;
import org.jsp.springbootproject.util.Accountstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class Merchantsercice {
	@Autowired
	private Merchantdao mdao;
	
	@Autowired
	private EmailService eservice;
	
	

	public ResponseEntity<Responsestructure<Merchant>> save(Merchant m,HttpServletRequest request) {
		Responsestructure<Merchant> structure = new Responsestructure<>();
		m.setStatus(Accountstatus.IN_ACTIVE.toString());
		m.setToken(RandomString.make(20));
		structure.setBody(mdao.save(m));
		String message=eservice.sendWelcomemail(m, request);
		structure.setMessage("merchant saved"+" "+message);
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<Merchant>> update(Merchant m) {
		Optional<Merchant> mer = mdao.findbyid(m.getId());
		Responsestructure<Merchant> structure = new Responsestructure<>();
		if (mer.isPresent()) {
			Merchant db = mer.get();
			db.setName(m.getName());
			db.setEmail(m.getEmail());
			db.setPhone(m.getPhone());
			db.setPassword(m.getPassword());
			structure.setMessage("merchant Updated Sucessfully");
			structure.setBody(mdao.save(db));
			structure.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<>(structure, HttpStatus.ACCEPTED);
		} 
		throw new IdNotFoundException("invalid id");
	}
	
	public ResponseEntity<Responsestructure<Merchant>> findbyid(int id)
	{
		Optional<Merchant>mer=mdao.findbyid(id);
		if(mer.isPresent())
		{
			Responsestructure<Merchant> structure = new Responsestructure<>();
			structure.setBody(mer.get());
			structure.setMessage("merchant updated");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<>(structure,HttpStatus.OK);	
		}
		
		throw new IdNotFoundException("invalid id");
	}
	
	
	public ResponseEntity<Responsestructure<Merchant>> verify(String email ,String password) {
		Optional<Merchant> m = mdao.verify(email, password);
		Responsestructure<Merchant>m1=new Responsestructure<>();
		if (m.isPresent()){
			m1.setBody(m.get());
			m1.setMessage("merchant verified sucessfully");
			m1.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<>(m1,HttpStatus.OK);
		}
		throw new InvalidCredentialException("invalid email or password");
	}

	public ResponseEntity<Responsestructure<Merchant>> verify(long phone ,String password) {
		Optional<Merchant> m = mdao.verify(phone, password);
		Responsestructure<Merchant>m1=new Responsestructure<>();
		if (m.isPresent()) {
			m1.setBody(m.get());
			m1.setMessage("merchant verified sucessfully");
			m1.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<>(m1,HttpStatus.OK);
		}
		throw new InvalidCredentialException("invalid phone or password");
	}

	public ResponseEntity<Responsestructure<String>> delete(int id) {
		Optional<Merchant> mer=mdao.findbyid(id);
		Responsestructure<String> str=new Responsestructure<>();
		if(mer.isPresent())
		{
			Merchant m=mer.get();
			mdao.delete(m);
			str.setBody(id+" is deleted");
			str.setMessage("merchant deleted");
			str.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<>(str,HttpStatus.OK);
		}
		throw new IdNotFoundException("id: "+id+" is not found");
	}

	public ResponseEntity<Responsestructure<String>> activate(String token) {
		Optional<Merchant> mer=mdao.findByToken(token);
		Responsestructure<String> str=new Responsestructure<>();
		if(mer.isPresent())
		{
			Merchant m=mer.get();
			m.setStatus(Accountstatus.ACTIVE.toString());
			m.setToken(null);
			mdao.save(m);
			str.setBody("merchant found");
			str.setMessage("Account verified and activated");
			str.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<>(str,HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException("invalid link");
	}
	
	


	
}
