package org.pmoo.packlaboratorio8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RosterTest {

	Roster r1;
	
	@Before
	public void setUp() throws Exception 
	{
		r1=r1.getRoster();
		r1.anadirParticipante("Manu", 10, 20);
		r1.anadirParticipante("Sergio", 20, 40);
	}

	@After
	public void tearDown() throws Exception 
	{
		r1.resetear();
	}

	@Test
	public void testGetRoster() 
	{
		assertNotNull(r1);
	}

	@Test
	public void testObtenerNumeroDeParticipantes() 
	{
		assertEquals(2,r1.obtenerNumeroDeParticipantes());
	}

	@Test
	public void testAnadirParticipante() 
	{
		try
		{
			r1.anadirParticipante("Sergio", 30, 20);
		}
		catch (Exception e)
		{
			fail("Ha saltado una excepción y no debería");
		}
		
		try
		{
			r1.anadirParticipante("Rodrigo", 10, 19);
		}
		catch (YaExisteIdException yeide)
		{
			System.out.print("No deberia saltar la excepción pues en el método el id se esta sumando hasta que sea válido");
		}
		catch (MenorDeEdadException mdee)
		{
			System.out.print("Ha saltado la excepción incorrecta");
		}
		
		try
		{
			r1.anadirParticipante("Leo", 40, 13);
			fail("Deberia haber saltado la excepción");
		}
		catch (YaExisteIdException yeide)
		{
			System.out.print("Ha saltado la excepción incorrecta");
		}
		catch (MenorDeEdadException mdee)
		{
			System.out.print("\nHa saltado la excepción correcta");
		}
	}

	@Test
	public void testBuscarParticipantePorId() 
	{
		try
		{
			
			Participante unParticipante=r1.buscarParticipantePorId(10);
			assertNotNull(unParticipante);
		}
		catch (NoEncontradoException noee)
		{
			fail("No debería saltar la excepción");
		}
		
		try
		{
			
			Participante unParticipante=r1.buscarParticipantePorId(70);
			assertNull(unParticipante);
		}
		catch (NoEncontradoException noee) {}
	}

}
