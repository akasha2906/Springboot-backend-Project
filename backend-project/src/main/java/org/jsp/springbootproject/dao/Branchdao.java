package org.jsp.springbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.dto.Branch;
import org.jsp.springbootproject.repo.Branchrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Branchdao {
	@Autowired
	private Branchrepo branchrepo;
	
	public Branch saveBranch(Branch Branch) {
		return branchrepo.save(Branch);
	}
	public Optional<Branch> findbyid(int id){
		return branchrepo.findById(id);	
	}
	public List<Branch> findAll(){
		return branchrepo.findAll();
	}
	public boolean deletebyid(int id) {
		Optional<Branch> recBranch=branchrepo.findById(id);
		if(recBranch.isPresent()) {
			branchrepo.delete(recBranch.get());
			return true;
		}else {
			return false;
		}
	}
	
	public Optional<Branch> verify(long phone,String email){
		return branchrepo.verify(phone, email);	
	}
	public Optional<Branch> verify(String email,String name){
		return branchrepo.verify(email, name);	
	}
	public List<Branch> verify(String name){
		return branchrepo.verify(name);	
	}
	
}

