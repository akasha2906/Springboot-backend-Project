package org.jsp.springbootproject.repo;

import java.util.List;
import org.jsp.springbootproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepo extends JpaRepository<Product, Integer> {
	
	@Query("select p from Product p where p.merchant.id=?1")
	public List<Product> bymid(int id);

}
