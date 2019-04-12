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

/**
 *
 * 	Está clase se encarga de enviar las operaciones lógicas al controller {@code SimpleController}
 *
 * @author Daniel.perez
 *
 */

@Component
public class PersonServices implements PersonaServiceImpl{

	/**
	 * Es la variable que llama al repositorio {@code PersonaRepository}
	 */
	@Autowired
	private PersonaRepository repo;

	/**
	* Este método se encarga de mostrar el listado en la tabla buscandolos en la base de datos a través del repositorio y mostrandolos.
	*
	* @see PersonDto
	*
	* @return retorna el listado
	*
 	*/
	public List<PersonDto> findAll() {
		List<PersonDto> listado = new ArrayList<PersonDto>();

		List<Persona> pd = repo.findAll();

		for (int i =0; i< pd.size();i++) {

			listado.add(PersonUtils._toConvertPersonaEntity(pd.get(i)));
		}

		 return listado;
	}

	/**
	 * Este método se encarga de crear/registrar el usuario en la tabla.
	 * Para ello recoge los datos del objeto {@code Persona} y los pasa al objeto {@code PersonDto},
	 * en caso de que no funcione salta la excepción.
	 *
	 * @param createPerson variable creada para llamar a la clase {@code PersonDto}
	 *
	 * @return retorna la lógica al controller {@code SimpleController}.
	 *
	 * @see SimpleController
	 *
	 */
	public PersonDto create(PersonDto createPerson) throws  BusinessException{

		try {

		return PersonUtils._toConvertPersonaEntity(repo.save(PersonUtils._toconvertPersonaDTO(createPerson)));

		}catch(DataIntegrityViolationException e) {
			throw new BusinessException("error.dni.duplicate", "dni");
		}
	}

	/**
	 * Este método se encarga de buscar por id al usuario.
	 *
	 * @param id variable para buscar por id al usuario.
	 *
	 * @return retorna la lógica al controller {@code SimpleController}.
	 *
	 * @see NoSuchElementException
	 * @see SimpleController
	 *
	 */
	public PersonDto findById(Long id) {

		return PersonUtils._toConvertPersonaEntity(repo.findById(id).orElseThrow(NoSuchElementException::new));
	}

	/**
	 * Este método sirve para actualizar el usuario ({@code Persona}) y guardando los cambios en la base de datos a través de la clase {@code PersonaRepository}
	 *
	 * 	@param updatePerson variable creada para llamar a la clase {@code PersonDto}
	 *
	 * @return retorna la lógica al controller {@code SimpleController}.
	 *
	 * @see PersonaRepository
	 * @see SimpleController
	 *
	 */
	public PersonDto updatePerson(PersonDto updatePerson) {
		return PersonUtils._toConvertPersonaEntity(repo.save(PersonUtils._toconvertPersonaDTO(updatePerson)));
	}

	/**
	 * Este método sirve para eliminar una {@code Persona} buscandola por id.
	 *
	 * @param id variable id que la útiliza para buscar la {@code Persona} por id y la elimina.
	 */

	public void delete(Long id) {
		repo.deleteById(id);
	}

	/**
	 * Este método sirve para buscar a la {@code Persona} por DNI.
	 *
	 * @return retorna la lógica al controller {@code SimpleController}.
	 */
	@Override
	public PersonDto findPersonByDni(String dni) {

		return PersonUtils._toConvertPersonaEntity(repo.findByDni(dni));
	}





}