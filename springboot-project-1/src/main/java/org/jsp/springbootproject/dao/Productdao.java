package org.jsp.springbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.model.Merchant;
import org.jsp.springbootproject.model.Product;
import org.jsp.springbootproject.repo.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Productdao {
	
	@Autowired
	private Productrepo prepo;
	
	public Product save(Product p)
	{
		return prepo.save(p);
	}
	
	public List<Product> findall()
	{
		return prepo.findAll();
	}
	
	public Optional<Product> findbyid(int id)
	{
		return prepo.findById(id);
	}
	
	public void delete(Product p)
	{
		prepo.delete(p);		
	}

	public List<Product> bymid(int id)
	{
		return prepo.bymid(id);
	}
}
