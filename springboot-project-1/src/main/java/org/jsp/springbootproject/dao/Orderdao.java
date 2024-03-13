package org.jsp.springbootproject.dao;

import org.jsp.springbootproject.model.Orderdetails;
import org.jsp.springbootproject.repo.Orderrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Orderdao {
	@Autowired
	private Orderrepo orepo;
	
	public Orderdetails save(Orderdetails orderd) {
		return orepo.save(orderd);
	}

}
