package org.jsp.springbootproject.repo;

import java.util.Optional;

import org.jsp.springbootproject.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface Merchantrepo extends JpaRepository<Merchant, Integer> {

	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	public Optional<Merchant> verify(long phone,String password);

	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
	public Optional<Merchant> verify(String email,String password);

	public Optional<Merchant> findByToken(String token);
	
}
