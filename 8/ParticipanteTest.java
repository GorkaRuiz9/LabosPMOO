package org.pmoo.packlaboratorio8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParticipanteTest {

	Participante p1;
	
	@Before
	public void setUp() throws Exception 
	{
		p1= new Participante("Lucas", 10, 20);
	}

	@After
	public void tearDown() throws Exception 
	{
		p1=null;
	}

	@Test
	public void testParticipante() 
	{
		try
		{
			Participante p2= new Participante(null, 0, 30);
		}
		catch(MenorDeEdadException mdee)
		{
			fail("Ha saltado la excepci�n y no deber�a");
		}
		
		try
		{
			Participante p3= new Participante(null, 0, 0);
			fail("Deber�a haber saltado la excepci�n");			
		}
		catch(MenorDeEdadException mdee){}
		catch(Exception e)
		{
			fail("Ha saltado otra excepci�n a la esperada");
		}
	}

	@Test
	public void testTieneEsteId() 
	{
		assertTrue(p1.tieneEsteId(10));
		assertFalse(p1.tieneEsteId(20));
	}

	@Test
	public void testObtenerNombre() 
	{
		assertEquals(p1.obtenerNombre(),"Lucas");
	}

	@Test
	public void testObtenerEdad() 
	{
		assertEquals(p1.obtenerEdad(),20);
	}

}
