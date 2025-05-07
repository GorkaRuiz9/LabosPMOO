package org.pmoo.packlaboratorio8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaParticipantesTest {

	Participante p1,p2,p3;
	ListaParticipantes l1= new ListaParticipantes();
	
	@Before
	public void setUp() throws Exception 
	{
		l1.anadirParticipante("Manuel", 10, 50);
		l1.anadirParticipante("Ernesto", 20, 20);
	}

	@After
	public void tearDown() throws Exception 
	{
		l1=new ListaParticipantes();
	}

	@Test
	public void testListaParticipantes() 
	{
		assertNotNull(l1);
	}

	@Test
	public void testObtenerNumeroDeParticipantes() 
	{
		assertEquals(l1.obtenerNumeroDeParticipantes(),2);
	}

	@Test
	public void testAnadirParticipante() 
	{
		try
		{
			l1.anadirParticipante("Sergio", 30, 20);
		}
		catch (Exception e)
		{
			fail("Ha saltado una excepci�n y no deber�a");
		}
		
		try
		{
			l1.anadirParticipante("Rodrigo", 10, 19);
			fail("Deberia haber saltado la excepci�n");
		}
		catch (YaExisteIdException yeide)
		{
			System.out.print("Ha saltado la excepci�n correcta");
		}
		catch (MenorDeEdadException mdee)
		{
			System.out.print("Ha saltado la excepci�n incorrecta");
		}
		
		try
		{
			l1.anadirParticipante("Leo", 40, 13);
			fail("Deberia haber saltado la excepci�n");
		}
		catch (YaExisteIdException yeide)
		{
			System.out.print("Ha saltado la excepci�n incorrecta");
		}
		catch (MenorDeEdadException mdee)
		{
			System.out.print("\nHa saltado la excepci�n correcta");
		}
		
		
	}

	@Test
	public void testObtenerParticipanteCuyoIdEs() 
	{		
		try
		{
			
			Participante unParticipante=l1.obtenerParticipanteCuyoIdEs(10);
			assertNotNull(unParticipante);
		}
		catch (NoEncontradoException noee)
		{
			fail("No deber�a saltar la excepci�n");
		}
		
		try
		{
			
			Participante unParticipante=l1.obtenerParticipanteCuyoIdEs(70);
			fail("Deber�a saltar la excepci�n");
		}
		catch (NoEncontradoException noee) {}
	}

}
