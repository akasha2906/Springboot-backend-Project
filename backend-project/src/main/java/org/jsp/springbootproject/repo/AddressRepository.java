package org.jsp.springbootproject.repo;

import java.util.Optional;

import org.jsp.springbootproject.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query("select a from Address a where a.state=?1 and a.pincode=?2")
	public Optional<Address> verify(String state, int pincode);
}
