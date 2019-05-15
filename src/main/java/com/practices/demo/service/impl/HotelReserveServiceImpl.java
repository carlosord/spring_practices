package com.practices.demo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practices.demo.dto.DtoAssembler;
import com.practices.demo.dto.PersonDto;
import com.practices.demo.dto.ReserveHotelDto;
import com.practices.demo.model.Hotel;
import com.practices.demo.model.Person;
import com.practices.demo.model.ReserveHotel;
import com.practices.demo.repositories.HotelRepository;
import com.practices.demo.repositories.HotelReserveRepository;
import com.practices.demo.repositories.PersonRepository;
import com.practices.demo.service.HotelReserveService;
import com.practices.demo.service.exception.BusinessException;
import com.practices.demo.service.utils.DateUtils;

/**
 * The Class HotelReserveServiceImpl.
 */
@Service
@Transactional
public class HotelReserveServiceImpl implements HotelReserveService {

	/** The hotel repository. */
	@Autowired
	private HotelRepository hotelRepository;

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/** The reserve repository. */
	@Autowired
	private HotelReserveRepository hotelReserveRepository;

	/**
	 * Adds the new hotel reserve.
	 *
	 * @param reservehotel the reservehotel
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	public boolean addNewReserve(ReserveHotelDto reservehotel) throws BusinessException {

		Person p = personRepository.findByDni(reservehotel.getDni());
		Hotel h = hotelRepository.findByCode(reservehotel.getCode());

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		List<ReserveHotel> hr = hotelReserveRepository.findReserveByPerson(p);

		try {

			if (h.getOccupiedbedrooms() == h.getTotalbedrooms())
				throw new BusinessException("hotel.code.error", "code");

			Date startDto = format.parse(reservehotel.getStartHotelReserve());
			Date finishDto = format.parse(reservehotel.getFinishHotelReserve());

			for (ReserveHotel r : hr) {

				DateUtils.checkDateHotel(r.getStartReserve(), startDto, r.getFinishReserve(), finishDto);

			}

			h.setOccupiedbedrooms(h.getOccupiedbedrooms() + 1);

			hotelReserveRepository.save(new ReserveHotel(p, h, startDto, finishDto));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return true;

	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<ReserveHotelDto> findHotelReserveByPerson(PersonDto p) {
		return hotelReserveRepository.findReserveByPerson(DtoAssembler.toEntity(p)).stream().map(DtoAssembler::fromEntity).collect(Collectors.toList());
	}



}
