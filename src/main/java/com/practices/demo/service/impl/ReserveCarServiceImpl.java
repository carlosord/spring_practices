package com.practices.demo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practices.demo.dto.CarReserveDto;
import com.practices.demo.model.Car;
import com.practices.demo.model.Person;
import com.practices.demo.model.ReserveCar;
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

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		List<ReserveCar> cr = reserveCarRepository.findReserveByPerson(p);

		try {

			Date start = format.parse(reservecar.getStartCarReserve());
			Date finish = format.parse(reservecar.getFinishCarReserve());

			for (ReserveCar r : cr) {

				if ((start.after(r.getStartReserve()) && start.before(r.getFinishReserve()))
						|| (finish.after(r.getStartReserve()) && finish.before(r.getFinishReserve()))) {

					throw new BusinessException("car.license.asigned", "license");
				}
			}

			reserveCarRepository.save(new ReserveCar(p, c, start, finish));

		} catch (ParseException e) {
			e.printStackTrace();

		}

		return true;

	}

}
