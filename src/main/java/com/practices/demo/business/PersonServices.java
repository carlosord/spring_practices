package com.practices.demo.business;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import com.practices.demo.dto.PersonDto;
import com.practices.demo.model.Persona;
import com.practices.demo.persistence.PersonaRepository;
import com.practices.demo.utils.PersonUtils;

@Component
public class PersonServices implements PersonaServiceImpl{

	@Autowired
	private PersonaRepository repo;

	public List<PersonDto> findAll() {
		List<PersonDto> listado = new ArrayList<PersonDto>();

		List<Persona> pd = repo.findAll();

		for (int i =0; i< pd.size();i++) {

			listado.add(PersonUtils._toConvertPersonaEntity(pd.get(i)));
		}

		 return listado;
	}

	public PersonDto create(PersonDto createPerson) throws  BusinessException{

		try {

		return PersonUtils._toConvertPersonaEntity(repo.save(PersonUtils._toconvertPersonaDTO(createPerson)));

		}catch(DataIntegrityViolationException e) {
			throw new BusinessException("error.dni.duplicate", "dni");
		}
	}

	public PersonDto findById( Long id) {

		return PersonUtils._toConvertPersonaEntity(repo.findById(id).orElseThrow(NoSuchElementException::new));
	}

	public PersonDto updatePerson(PersonDto updatePerson) {
		return PersonUtils._toConvertPersonaEntity(repo.save(PersonUtils._toconvertPersonaDTO(updatePerson)));
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public PersonDto findPersonByDni(String dni) {

		return PersonUtils._toConvertPersonaEntity(repo.findByDni(dni));
	}





}