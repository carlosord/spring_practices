package com.practices.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practices.demo.dto.CarReserveDto;
import com.practices.demo.dto.DtoAssembler;
import com.practices.demo.model.Associations;
import com.practices.demo.model.Car;
import com.practices.demo.model.Person;
import com.practices.demo.model.ReserveCarDate;
import com.practices.demo.repositories.CarRepository;
import com.practices.demo.repositories.PersonRepository;
import com.practices.demo.repositories.ReserveCarRepository;
import com.practices.demo.service.ReserveCarService;
import com.practices.demo.service.exception.BusinessException;

/**
 * The Class ReserveCarServiceImpl.
 */
@Service
@Transactional
public class ReserveCarServiceImpl implements ReserveCarService {

	/** The car repository. */
	@Autowired
	private CarRepository carRepository;

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/** The reserve car repository. */
	@Autowired
	private ReserveCarRepository reserveCarRepository;

	/**
	 * Adds the car.
	 *
	 * @param reservecar the reservecar
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	@Override
	public boolean addCar(CarReserveDto reservecar) throws BusinessException {

		Car c = carRepository.findByLicense(reservecar.getLicense());
		Person p = personRepository.findByDni(reservecar.getDni());

		ReserveCarDate cd = DtoAssembler.toEntity(reservecar);

//		if (c.getPerson() != null) {
//			throw new BusinessException("car.license.asigned", "license");
//		}

		Associations.ReserveCar.link(cd, c, p);

//		carRepository.save(c);
//		personRepository.save(p);
		reserveCarRepository.save(cd);

		return true;

	}

}
