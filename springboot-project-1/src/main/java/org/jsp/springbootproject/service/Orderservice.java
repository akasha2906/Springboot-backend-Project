package org.jsp.springbootproject.service;

import org.jsp.springbootproject.dao.Orderdao;
import org.jsp.springbootproject.dto.Responsestructure;
import org.jsp.springbootproject.model.Orderdetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Orderservice {
	
	private Orderdao odao;

	public ResponseEntity<Responsestructure<Orderdetails>> save(Orderdetails orderd) {
		Responsestructure<Orderdetails> str=new Responsestructure<>();
		str.setBody(odao.save(orderd));
		str.setMessage("order saved");
		str.setStatuscode(HttpStatus.CREATED.value());
		
		return null;
	}

}
