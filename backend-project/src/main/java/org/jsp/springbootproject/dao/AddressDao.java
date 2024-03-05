package org.jsp.springbootproject.dao;

import java.util.Optional;

import org.jsp.springbootproject.dto.Address;
import org.jsp.springbootproject.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {
	
		@Autowired
		private AddressRepository repository;
		
		public Address saveAddress(Address a) {
			return repository.save(a);
		}
		
		public Address updateAddress(Address a) {
			return repository.save(a);
		}
		
		public Optional<Address> findById(int id) {
			return repository.findById(id);
		}
		
		public Optional<Address> verify(String state, int pincode){
			return repository.verify(state, pincode);
		}
}
