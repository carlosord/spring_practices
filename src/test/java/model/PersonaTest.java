package model;

import org.junit.Assert;
import org.junit.Test;

import com.practices.demo.model.Persona;



public class PersonaTest {

	@Test
	public void testFullName() {

		Persona p= new Persona();

		p.setName("Paco");
		p.setLastname("Garcia");

		Assert.assertEquals("No son iguales", p.getName() + " " + p.getLastname(), p.getFullname());

	}

}
