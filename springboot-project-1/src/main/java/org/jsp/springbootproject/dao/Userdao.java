package org.jsp.springbootproject.dao;

import java.util.Optional;

import org.jsp.springbootproject.model.User;
import org.jsp.springbootproject.repo.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class Userdao {
	@Autowired
	private Userrepo urepo;

	public User save(User u) {
		return urepo.save(u);
	}

	public Optional<User> findbyid(int id){
		return urepo.findById(id);
	}
	
	public void delete(User u)
	{
		urepo.delete(u);
	}
	
	public Optional<User> verify(String email, String password)
	{
		return urepo.verify(email,password);
	}
	public Optional<User> verify(long phone, String password)
	{
		return urepo.verify(phone,password);
	}

	public Optional<User> findByToken(String token) {
		return urepo.findByToken(token);
	}

}
