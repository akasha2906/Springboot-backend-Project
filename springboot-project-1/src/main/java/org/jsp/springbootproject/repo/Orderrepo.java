package org.jsp.springbootproject.repo;

import org.jsp.springbootproject.model.Orderdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Orderrepo extends JpaRepository<Orderdetails, Integer>{

}
