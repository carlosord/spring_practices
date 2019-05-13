package com.practices.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practices.demo.dto.CarReserveDto;
import com.practices.demo.dto.DtoAssembler;
import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Car;
import com.practices.demo.model.Person;
import com.practices.demo.repositories.CarRepository;
import com.practices.demo.repositories.PersonRepository;
import com.practices.demo.service.PersonService;
import com.practices.demo.service.exception.BusinessException;

/**
 * The Class PersonServiceImpl.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/** The person repository. */
	@Autowired
	private CarRepository carRepository;

	/**
	 * Find person by id.
	 *
	 * @param id the id
	 * @return the person dto
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.practices.demo.service.PersonService#findPersonById(java.lang.Long)
	 */
	public PersonDto findPersonById(Long id) {
		return DtoAssembler.fromEntity(personRepository.findById(id).orElseThrow(NoSuchElementException::new));
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see com.practices.demo.service.PersonService#findAll()
	 */
	public List<PersonDto> findAll() {
		return personRepository.findAll().stream().map(DtoAssembler::fromEntity).collect(Collectors.toList());
	}

	/**
	 * Find person by dni.
	 *
	 * @param dni the dni
	 * @return the person dto
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.practices.demo.service.PersonService#findPersonByDni(java.lang.String)
	 */
	public PersonDto findPersonByDni(String dni) {

		return DtoAssembler.fromEntity(personRepository.findByDni(dni));

	}

	/**
	 * Adds the new person.
	 *
	 * @param person the person
	 * @return the person dto
	 * @throws BusinessException the business exception
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.practices.demo.service.PersonService#addNewPerson(com.practices.demo.dto.
	 * PersonDto)
	 */
	public PersonDto addNewPerson(PersonDto person) throws BusinessException {

		try {
			// Add new person to db
			return DtoAssembler.fromEntity(personRepository.save(DtoAssembler.toEntity(person)));
		} catch (DataIntegrityViolationException e) {
			throw new BusinessException("person.dni.error.duplicate", "dni");
		}

		/**
		 * Other impl // Check if dni already exist if (findPersonByDni(person.getDni())
		 * != null) throw new BusinessException("person.dni.error.duplicate", "dni");
		 *
		 * // Add new person to db return DtoAssembler.fromEntity(
		 * personRepository.save(DtoAssembler.toEntity(person)));
		 **/

	}

	/**
	 * Update person.
	 *
	 * @param person the person
	 * @return the person dto
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.practices.demo.service.PersonService#updatePerson(com.practices.demo.dto.
	 * PersonDto)
	 */
	public PersonDto updatePerson(PersonDto person) {

		// Update person
		return DtoAssembler.fromEntity(personRepository.save(DtoAssembler.toEntity(person)));
	}

	/**
	 * Delete person form.
	 *
	 * @param id the id
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.practices.demo.service.PersonService#deletePersonForm(java.lang.Long)
	 */
	public void deletePersonForm(Long id) {

		// Delete the person
		personRepository.deleteById(id);
	}

	/**
	 * Adds the car.
	 *
	 * @param car the car
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.practices.demo.service.PersonService#addNewCar(com.practices.demo.dto.
	 * PersonDto)
	 */
	@Override
	public boolean addCar(CarReserveDto car) throws BusinessException {

		Car c = carRepository.findByLicense(car.getLicense());
		Person p = personRepository.findByDni(car.getDni());

//		if (c.getPerson() != null) {
//			throw new BusinessException("car.license.asigned", "license");
//		}

//		Associations.ReserveCar.link(p, c);

		carRepository.save(c);
		personRepository.save(p);

		return true;

	}

}
