package org.jsp.springbootproject.dao;

import java.util.Optional;

import org.jsp.springbootproject.model.Merchant;
import org.jsp.springbootproject.repo.Merchantrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Merchantdao {
	@Autowired
	private Merchantrepo mrepo;

	public Merchant save(Merchant m) {
		return mrepo.save(m);
	}

	public Optional<Merchant> findbyid(int id)
	{
		return mrepo.findById(id);
	}
	
	public Optional<Merchant> verify(String email, String password)
	{
		return mrepo.verify(email,password);
	}
	
	public void delete(Merchant m)
	{
		mrepo.delete(m);		
	}
	
	public Optional<Merchant> verify(long phone, String password)
	{
		return mrepo.verify(phone,password);
	}

	public Optional<Merchant> findByToken(String token) {
		
		return mrepo.findByToken(token);
	}

}
