package com.practices.demo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practices.demo.dto.DetailsReserveHotelDto;
import com.practices.demo.dto.DtoAssembler;
import com.practices.demo.dto.ListHotelDto;
import com.practices.demo.dto.ReserveHotelDto;
import com.practices.demo.model.Hotel;
import com.practices.demo.model.Person;
import com.practices.demo.model.ReserveHotel;
import com.practices.demo.repositories.HotelRepository;
import com.practices.demo.repositories.HotelReserveRepository;
import com.practices.demo.repositories.PersonRepository;
import com.practices.demo.service.HotelReserveService;
import com.practices.demo.service.MailService;
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

	/** The hotel reserve repository. */
	@Autowired
	private HotelReserveRepository hotelReserveRepository;

	/** The mail service. */
	@Autowired
	private MailService mailService;

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

		List<ReserveHotel> hr = hotelReserveRepository.findByPersonDni(p.getDni());

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

			mailService.sendEmail(p);

		} catch (ParseException e) {

		}

		return true;

	}

	/**
	 * Find all.
	 *
	 * @param dni the dni
	 * @return the list
	 */
	@Override
	public List<ListHotelDto> findHotelReserveByPersonDni(String dni) {

		return hotelReserveRepository.findByPersonDni(dni).stream().map(DtoAssembler::fromListEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Find hotel reserve by period.
	 *
	 * @param start the start
	 * @param finish the finish
	 * @return the list
	 */
	@Override
	public List<DetailsReserveHotelDto> findHotelReserveByPeriod(Date start, Date finish) {

		return hotelReserveRepository.findByPeriod(start, finish).stream().map(DtoAssembler::fromListHotelDateEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Find hotel reserve tomorrow.
	 *
	 * @return the list
	 */
	@Override
	public List<DetailsReserveHotelDto> findHotelReserveTomorrow() {

		Date today = new Date();
		// Date tomorrowDate= new Date(today.getTime() + (1000 * 60 * 60 * 24));
		Date tomorrowDate = new Date(today.getTime() + TimeUnit.DAYS.toDays(1));

		return findHotelReserveByPeriod(today, tomorrowDate);
	}

}
