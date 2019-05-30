package com.practices.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practices.demo.dto.CarDto;
import com.practices.demo.dto.DtoAssembler;
import com.practices.demo.repositories.CarRepository;
import com.practices.demo.service.CarService;

/**
 * The Class CarServiceImpl.
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {

	/** The person repository. */
	@Autowired
	private CarRepository carRepository;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.practices.demo.service.PersonService#findCarById(java.lang.Long)
	 */
	@Override
	public CarDto findCarById(Long id) {
		return DtoAssembler.fromEntity(carRepository.findById(id).orElseThrow(NoSuchElementException::new));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.practices.demo.service.CarService#findAll()
	 */
	@Override
	public List<CarDto> findAll() {
		return carRepository.findAll().stream().map(DtoAssembler::fromEntity).collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.practices.demo.service.CarService#findByLicense(java.lang.String)
	 */
	@Override
	public CarDto findByLicense(String license) {
		return DtoAssembler.fromEntity(carRepository.findByLicense(license));
	}

}
