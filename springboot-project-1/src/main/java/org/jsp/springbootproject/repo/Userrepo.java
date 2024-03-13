package org.jsp.springbootproject.repo;

import java.util.Optional;

import org.jsp.springbootproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface Userrepo extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.phone=?1 and u.password=?2")
	public Optional<User> verify(long phone,String password);

	@Query("select u from User u where u.email=?1 and u.password=?2")
	public Optional<User> verify(String email,String password);

	public Optional<User> findByToken(String token);

}
