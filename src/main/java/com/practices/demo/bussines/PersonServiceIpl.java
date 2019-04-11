package com.practices.demo.bussines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.practices.demo.dto.PersonaDTO;
import com.practices.demo.model.Persona;
import com.practices.demo.persistence.PersonaRepository;
import com.practices.demo.utils.PersonUtils;

@Component
public class PersonServiceIpl implements PersonService {

	@Autowired
	private PersonaRepository repo;

	public List<PersonaDTO> findAll() {

		List<PersonaDTO> listdto = new ArrayList<PersonaDTO>();

		List<Persona> personlist = repo.findAll();

		for (int i = 0; i < personlist.size(); i++) {

			listdto.add(PersonUtils._toConvertPersonEntity(personlist.get(i)));

		}

		return listdto;

	}

	public PersonaDTO registerUser(PersonaDTO createperson) throws Exception {

		if (repo.findByDni(createperson.getDni()) != null)
			throw new Exception("error.dni.duplicated");

		Persona p = repo.save(PersonUtils._toConvertPersonDTO(createperson));

		return PersonUtils._toConvertPersonEntity(p);

	}

	public PersonaDTO edituser(String id) {

		Persona p = repo.findById(Long.valueOf(id))
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		return PersonUtils._toConvertPersonEntity(p);

	}

	public PersonaDTO updatePerson(PersonaDTO updateperson) {

		Persona p = repo.save(PersonUtils._toConvertPersonDTO(updateperson));

		return PersonUtils._toConvertPersonEntity(p);

	}

	public void deleteUser(long id) {

		repo.deleteById(id);

	}

}
