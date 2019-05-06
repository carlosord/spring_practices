package com.practices.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practices.demo.dto.DtoAssembler;
import com.practices.demo.dto.HotelDto;
import com.practices.demo.repositories.HotelRepository;
import com.practices.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	/** The hotel repository. */
	@Autowired
	private HotelRepository hotelRepository;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.practices.demo.service.HotelService#findHotelById(java.lang.Long)
	 */
	public HotelDto findHotelById(Long id) {
		return DtoAssembler.fromEntity(hotelRepository.findById(id).orElseThrow(NoSuchElementException::new));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.practices.demo.service.HotelService#findAll()
	 */
	public List<HotelDto> findAll() {
		return hotelRepository.findAll().stream().map(DtoAssembler::fromEntity).collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.practices.demo.service.HotelService#findHotelByCode(java.lang.String)
	 */
	public HotelDto findHotelByCode(String code) {

		return DtoAssembler.fromEntity(hotelRepository.findByCode(code));
	}

}
