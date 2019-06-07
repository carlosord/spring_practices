package com.practices.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practices.demo.dto.DtoAssembler;
import com.practices.demo.dto.InfoPersonDto;
import com.practices.demo.dto.PersonDto;
import com.practices.demo.repositories.PersonRepository;
import com.practices.demo.service.HotelReserveService;
import com.practices.demo.service.PersonService;
import com.practices.demo.service.ReserveCarService;
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

	/** The reserve car service. */
	@Autowired
	private ReserveCarService reserveCarService;

	/** The hotel reserve service. */
	@Autowired
	private HotelReserveService hotelReserveService;

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
	public void deletePerson(Long id) {

		// Delete the person
		personRepository.deleteById(id);
	}

	/**
	 * Show reserves person.
	 *
	 * @param id the id
	 * @return the info person dto
	 */
	public InfoPersonDto showReservesPerson(Long id) {

		PersonDto person = this.findPersonById(id);
		InfoPersonDto infoPerson = new InfoPersonDto();

		infoPerson.setPerson(person);
		infoPerson.setHotelList(hotelReserveService.findHotelReserveByPersonDni(person.getDni()));
		infoPerson.setCarList(reserveCarService.findCarReserveByPersonDni(person.getDni()));

		return infoPerson;
	}

}
