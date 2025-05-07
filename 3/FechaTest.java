package org.pmoo.packlaboratorio3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FechaTest {
	Fecha fecha;
	
	@Before
	public void setUp() throws Exception {
		fecha = new Fecha(1,1,2020);
	}

	@After
	public void tearDown() throws Exception {
		fecha = null;
	}

	@Test
	public void testEsBisiesto() {
		assertTrue(fecha.esBisiesto()); //caso bisiesto
		fecha = new Fecha(1,1,2021);
		assertFalse(fecha.esBisiesto()); //caso no bisiesto
	}
	

	@Test
	public void testIncrementar() {
		//caso regular
		fecha.incrementar();
		assertEquals("02/01/2020", fecha.toString());
		//System.out.print(fecha.toString() + "\n");
		fecha.incrementar();
		assertNotEquals("01/01/2020", fecha.toString());
		
		//caso dia max por mes
		fecha = new Fecha(31,1,2000);
		fecha.incrementar();
		assertEquals("01/02/2000", fecha.toString());
		
		//caso dia max y mes max
		fecha = new Fecha(31,12,2000);
		fecha.incrementar();
		assertEquals("01/01/2001", fecha.toString());
	}

	@Test
	public void testDecrementar() {
		//caso regular
		fecha = new Fecha(21,5,2000);
		fecha.decrementar();
		//System.out.print(fecha.toString() + "\n");
		assertEquals("20/05/2000", fecha.toString());
		assertNotEquals("53/05/2000", fecha.toString());
		
		//caso dia min
		fecha = new Fecha(1,7,2000);
		fecha.decrementar();
		//System.out.print(fecha.toString() + "\n");
		assertEquals("30/06/2000", fecha.toString());
		
		//caso dia min y mes min
		fecha = new Fecha(1,1,2000);
		fecha.decrementar();
		//System.out.print(fecha.toString() + "\n");
		assertEquals("31/12/1999", fecha.toString());
	}

}
