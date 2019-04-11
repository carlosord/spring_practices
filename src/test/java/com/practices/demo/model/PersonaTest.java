package com.practices.demo.model;

import org.junit.Assert;
import org.junit.Test;


public class PersonaTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	@Test
	public void testFullname() {
		Persona p = new Persona();
		p.setName("Paco");
		p.setLastname("Ramirez");
		Assert.assertEquals("No son iguales", p.getName() + " " + p.getLastname(), p.getFullname());
	}

}
