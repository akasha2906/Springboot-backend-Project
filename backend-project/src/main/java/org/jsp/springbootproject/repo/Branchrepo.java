package org.jsp.springbootproject.repo;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootproject.dto.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Branchrepo extends JpaRepository<Branch, Integer> {
	@Query("select b from Branch b where b.phone=?1 and b.email=?2")
	public Optional<Branch> verify(long phone,String email);
	
	@Query("select b from Branch b where b.email=?1 and b.name=?2")
	public Optional<Branch> verify(String email,String name);
	
	@Query("select b from Branch b where b.name=?1")
	public List<Branch> verify(String name);

}
