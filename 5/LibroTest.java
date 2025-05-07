package org.pmoo.packlaboratorio5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class LibroTest extends TestCase
{
	Libro l1, l2, l3;

	@Before
	public void setUp()
	{
		l1=new Libro("El amor dura tres años", "Frederic Beigbeder",4);
	}

	@After
	public void tearDown()
	{
		l1=null;
	}

	@Test
	public void testTieneEsteId()
	{
		assertTrue(l1.tieneEsteId(4));
		assertFalse(l1.tieneEsteId(5));
	}

	@Test
	public void testTieneElMismoId()
	{
		l2=new Libro(getName(), getName(), 4);
		l3=new Libro(getName(), getName(), 10);
		assertTrue(l1.tieneElMismoId(l2));
		assertFalse(l1.tieneElMismoId(l3));
		
	}

	@Test
	public void testImprimir()
	{
		assertNotNull(l1);

		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase Libro");
		System.out.println("\nLa información del libro debería mostrarse de este modo:\n");
		System.out.println("* El amor dura tres años, escrito por Frederic Beigbeder.");
		System.out.println("\nY tu programa lo muestra de este modo:\n");
		l1.imprimir();
		System.out.println("\n===============================================================");

		
	}

}
