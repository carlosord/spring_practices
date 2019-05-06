package com.practices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practices.demo.model.Person;

/**
 * The Interface PersonRepository.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByDni(String dni);

}
