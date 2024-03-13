package org.jsp.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.dao.Merchantdao;
import org.jsp.springbootproject.dao.Productdao;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.exception.IdNotFoundException;
import org.jsp.springbootproject.model.Merchant;
import org.jsp.springbootproject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Productservice {

	@Autowired
	private Productdao pdao;
	@Autowired
	private Merchantdao mdao;

	public ResponseEntity<Responsestructure<Product>> save(Product p, int id) 
	{
		Optional<Merchant> recmerchant=mdao.findbyid(id);
		Responsestructure<Product> structure=new Responsestructure<>();
		if(recmerchant.isPresent()) {
			Merchant merchant=recmerchant.get();
			merchant.getProducts().add(p);
			p.setMerchant(merchant);
			structure.setBody(pdao.save(p));
			structure.setMessage("Product Saved Sucessfully");
			structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<Responsestructure<Product>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException("Could not Save Product As Merchant ID Is Invalid");
		
	}
	
	public ResponseEntity<Responsestructure<Product>> Update(Product p, int id) {
		Optional<Product> pr=pdao.findbyid(p.getId());
		Responsestructure<Product> structure=new Responsestructure<>();
		if(pr.isPresent())
		{
			Product db = pr.get();
			db.setName(p.getName());
			db.setAbout(p.getAbout());
			db.setModel(p.getModel());
			db.setPrice(p.getPrice());
			db.setImageurl(p.getImageurl());
			db.setBrand(p.getBrand());
			structure.setMessage("merchant Updated Sucessfully");
			structure.setBody(pdao.save(db));
			structure.setStatuscode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<>(structure, HttpStatus.ACCEPTED);
		}
		return null;
	}

	public ResponseEntity<Responsestructure<Product>> findbyid(int id)
	{
		Optional<Product> p=pdao.findbyid(id);
		Responsestructure<Product> str=new Responsestructure<>();
		if(p.isPresent())
		{
			str.setBody(p.get());
			str.setMessage(id+" is found");
			str.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<Responsestructure<Product>>(str,HttpStatus.OK);
		}
		throw new IdNotFoundException("Id not found");
	}
	
	public ResponseEntity<Responsestructure<List<Product>>> findall()
	{
		Responsestructure<List<Product>> str=new Responsestructure<>();
		
		str.setBody(pdao.findall());
		str.setMessage("All products");
		str.setStatuscode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(str,HttpStatus.OK);
		
	}
	
	public ResponseEntity<Responsestructure<List<Product>>> bymid(int id)
	{
		Optional<Merchant> mer=mdao.findbyid(id);
		Responsestructure<List<Product>> str=new Responsestructure<>();
		if(mer.isPresent())
		{
			str.setBody(pdao.bymid(id));
			str.setMessage("products of merchant "+id);
			str.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<>(str, HttpStatus.OK);
		}
		
		throw new IdNotFoundException("merchant id not found "+id);
	}

	public ResponseEntity<Responsestructure<String>> delete(int id) {
		Optional<Product> pr=pdao.findbyid(id);
		Responsestructure<String> str=new Responsestructure<>();
		if(pr.isPresent())
		{
			Product p=pr.get();
			pdao.delete(p);
			str.setBody(id+" is deleted");
			str.setMessage("Product deleted");
			str.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<>(str,HttpStatus.OK);
		
		}
		return null;
	}

}
