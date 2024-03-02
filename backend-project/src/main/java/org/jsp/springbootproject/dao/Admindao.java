package org.jsp.springbootproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.dto.Admin;
import org.jsp.springbootproject.repo.Adminrepo;

@Repository
public class Admindao {
	@Autowired
	private Adminrepo arepo;
	
	public Admin saveAdmin(Admin Admin) {
		return arepo.save(Admin);
	}
	public Optional<Admin> findbyid(int id){
		return arepo.findById(id);	
	}
	public List<Admin> findAll(){
		return arepo.findAll();
	}
	public boolean deletebyid(int id) {
		Optional<Admin> recAdmin=arepo.findById(id);
		if(recAdmin.isPresent()) {
			arepo.delete(recAdmin.get());
			return true;
		}else {
			return false;
		}
	}
	
	public Optional<Admin> verify(long phone,String password){
		return arepo.verify(phone, password);	
	}
	public Optional<Admin> verify(String email,String password){
		return arepo.verify(email, password);	
	}
	public List<Admin> verify(String name){
		return arepo.verify(name);	
	}
	
	

}
