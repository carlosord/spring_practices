package com.practices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query("SELECT p FROM Person p WHERE p.dni=(:dni)")
	Person findByDni(@Param("dni") String dni);
 
}
