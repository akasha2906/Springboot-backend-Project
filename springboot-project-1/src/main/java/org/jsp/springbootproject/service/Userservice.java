package org.jsp.springbootproject.service;

import java.util.Optional;

import org.jsp.springbootproject.dao.Userdao;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.exception.IdNotFoundException;
import org.jsp.springbootproject.exception.InvalidCredentialException;
import org.jsp.springbootproject.model.User;
import org.jsp.springbootproject.util.Accountstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class Userservice {
	@Autowired
	private Userdao udao;
	@Autowired
	private EmailService eservice;	

	public ResponseEntity<Responsestructure<User>> save(User u,HttpServletRequest request) {
		Responsestructure<User> structure = new Responsestructure<>();
		u.setStatus(Accountstatus.IN_ACTIVE.toString());
		u.setToken(RandomString.make(20));
		structure.setBody(udao.save(u));
		String message=eservice.sendWelcomemail(u, request);
		structure.setMessage("user saved");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<User>> update(User u) {
		Responsestructure<User> structure = new Responsestructure<>();
		structure.setBody(udao.save(u));
		structure.setMessage("User updated");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<User>> findbyid(int id)
	{
		Optional<User> user=udao.findbyid(id);
		Responsestructure<User> str=new Responsestructure<>();
		if(user.isPresent())
		{
		str.setMessage("User id" +id);
		str.setBody(user.get());
		str.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<>(str,HttpStatus.OK);
		}
		throw new IdNotFoundException("invalid id");
	}

	public ResponseEntity<Responsestructure<String>> delete(int id)
	{
		Optional<User> user=udao.findbyid(id);
		Responsestructure<String> str=new Responsestructure<>();
		if(user.isPresent())
		{
			User u=user.get();
			udao.delete(u);
			str.setMessage(id+" is deleted");
			str.setBody("User deleted");
			str.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<>(str,HttpStatus.OK);
		}
		throw new IdNotFoundException("id: "+id+" is not found");
	}
	
	public ResponseEntity<Responsestructure<User>> verify(String email, String password) {
		Optional<User> m = udao.verify(email, password);
		Responsestructure<User> m1 = new Responsestructure<>();
		if (m.isPresent()) {
			m1.setBody(m.get());
			m1.setMessage("user verified sucessfully");
			m1.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<>(m1,HttpStatus.CREATED);
		}
		throw new InvalidCredentialException("invalid email or password");
	}

	public ResponseEntity<Responsestructure<User>> verify(long phone, String password) {
		Optional<User> u = udao.verify(phone, password);
		Responsestructure<User> u1 = new Responsestructure<>();
//		System.out.println(u.get());
		if (u.isPresent()) {
			u1.setBody(u.get());
			u1.setMessage("user verified sucessfully");
			u1.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<>(u1,HttpStatus.CREATED);
		}
		throw new InvalidCredentialException("invalid phone or password");
	}

	public ResponseEntity<Responsestructure<String>> activate(String token) {
		Optional<User> user=udao.findByToken(token);
		Responsestructure<String> str=new Responsestructure<>();
		if(user.isPresent())
		{
			User u=user.get();
			u.setStatus(Accountstatus.ACTIVE.toString());
			u.setToken(null);
			udao.save(u);
			str.setBody("user found");
			str.setMessage("Account verified and activated");
			str.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<>(str,HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException("invalid link");
	}
}
