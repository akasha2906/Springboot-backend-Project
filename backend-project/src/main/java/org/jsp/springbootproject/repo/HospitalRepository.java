package org.jsp.springbootproject.repo;

import org.jsp.springbootproject.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	
}
