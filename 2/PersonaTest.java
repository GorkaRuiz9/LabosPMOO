package org.pmoo.packlaboratorio1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonaTest {
	
	Persona p1, p2;

	@Before
	public void setUp() throws Exception 
	{
		p1 = new Persona("Pepe Apellido", 20, 16, "A-", "Estadounidense");
		p2 = new Persona("Maria Apellido", 18, 21,"O+", "Vasca");
	}

	@After
	public void tearDown() throws Exception 
	{
		p1 = null;
		p2 = null;
	}

	@Test
	public void testPersonaStringIntIntStringString() 
	{
		assertNotNull(p1);
		assertNotNull(p2);
	}

	@Test
	public void testTieneMismoID() 
	{
		//Caso 1: diferente ID
		assertFalse(p1.tieneMismoID(p2));
		assertFalse(p2.tieneMismoID(p1));
		
		//Caso 2: mismo ID
		Persona p3 = new Persona("Pepe Apellido", 20, 16, "A-", "Estadounidense");
		p2 = new Persona(null, 0, 16, null, null);
		assertTrue(p1.tieneMismoID(p3));
		assertTrue(p1.tieneMismoID(p2));
	}

	@Test
	public void testPuedeConducir() 
	{
		//Resto
		assertTrue(p1.puedeConducir());
		p1 = new Persona(null, 9, 0, null, "Vasca");
		assertFalse(p1.puedeConducir());
		//Etíope 
		p1 = new Persona(null, 9, 0, null, "Etíope");
		assertFalse(p1.puedeConducir());
		p1 = new Persona(null, 16, 0, null, "Etíope");
		assertTrue(p1.puedeConducir());
		//Australiana
		p1 = new Persona(null, 9, 0, null, "Australiana");
		assertFalse(p1.puedeConducir());
		p1 = new Persona(null, 16, 0, null, "Australiana");
		assertTrue(p1.puedeConducir());
		//Estadounidense
		p1 = new Persona(null, 5, 0, null, "Etíope");
		assertFalse(p1.puedeConducir());
		p1 = new Persona(null, 19, 0, null, "Etíope");
		assertTrue(p1.puedeConducir());
		//Británica
		p1 = new Persona(null, 2, 0, null, "Etíope");
		assertFalse(p1.puedeConducir());
		p1 = new Persona(null, 17, 0, null, "Etíope");
		assertTrue(p1.puedeConducir());
	}

	@Test
	public void testInicialNombre() 
	{
		assertEquals('P',p1.inicialNombre());
		assertNotEquals('M',p1.inicialNombre());
	}

	@Test
	public void testInicialApellido() 
	{
		//Nombre simple
		assertEquals('A',p1.inicialApellido());
		assertNotEquals('F',p1.inicialApellido());
		//Nombre compuesto
		p1 = new Persona("Enzo Rodriguez Fernández", 0, 0, null, null);
		assertEquals('F',p1.inicialApellido());
		assertNotEquals('G',p1.inicialApellido());
		//Nombre compuesto triple
		p1 = new Persona("Enzo Rodriguez Fernández Martinez", 0, 0, null, null);
		assertEquals('M',p1.inicialApellido());
		assertNotEquals('G',p1.inicialApellido());
		
		
	}

	@Test
	public void testPuedeDonarleSangre() 
	{
		p1 = new Persona(null, 0, 0, "0+", null);
		
		p2 = new Persona(null, 0, 0, "0+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "0-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		
		p1 = new Persona(null, 0, 0, "0-", null);
		
		p2 = new Persona(null, 0, 0, "0+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "0-", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A-", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B-", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB-", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		
		p1 = new Persona(null, 0, 0, "A+", null);
		
		p2 = new Persona(null, 0, 0, "0+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "0-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		
		p1 = new Persona(null, 0, 0, "A-", null);
		
		p2 = new Persona(null, 0, 0, "0+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "0-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A-", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB-", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		
		p1 = new Persona(null, 0, 0, "B+", null);
		
		p2 = new Persona(null, 0, 0, "0+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "0-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		
		p1 = new Persona(null, 0, 0, "B-", null);
		
		p2 = new Persona(null, 0, 0, "0+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "0-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B-", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB-", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		
		p1 = new Persona(null, 0, 0, "AB+", null);
		
		p2 = new Persona(null, 0, 0, "0+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "0-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		
		p1 = new Persona(null, 0, 0, "AB-", null);
		
		p2 = new Persona(null, 0, 0, "0+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "0-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "A-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B+", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "B-", null);
		assertFalse(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB+", null);
		assertTrue(p1.puedeDonarleSangre(p2));
		p2 = new Persona(null, 0, 0, "AB-", null);
		assertTrue(p1.puedeDonarleSangre(p2));
	}

}
