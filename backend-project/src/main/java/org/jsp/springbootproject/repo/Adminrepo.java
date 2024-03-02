package org.jsp.springbootproject.repo;


import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Adminrepo extends JpaRepository<Admin, Integer> {
	@Query("select m from Admin m where m.phone=?1 and m.password=?2")
	public Optional<Admin> verify(long phone,String password);
	
	@Query("select m from Admin m where m.email=?1 and m.password=?2")
	public Optional<Admin> verify(String email,String password);
	@Query("select m from Admin m where m.name=?1")
	public List<Admin> verify(String name);

}
