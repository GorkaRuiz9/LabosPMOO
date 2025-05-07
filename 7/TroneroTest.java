package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TroneroTest {

	Tronero c1,c2;
	
	@Before
	public void setUp() throws Exception 
	{
		c1= new Tronero(null, 2);
		c2= new Tronero(null, 2);
	}

	@After
	public void tearDown() throws Exception 
	{
		c1=null;
		c2=null;
	}

	@Test
	public void testCumpleLasReglas() 
	{
		//Vamos identificando caso por caso
		
		//Caso 1: puntuación negativa / puntuación negativa en el nominador
		Pretendista c3= new Pretendista(null, -12);
		c1.nominar(c3);
		assertFalse(c1.cumpleLasReglas());
		
		assertFalse(c3.cumpleLasReglas());
		
		//Caso 2: tiene en su lista a troneros y pretendistas al mismo tiempo
		Pretendista c4= new Pretendista(null, 4);
		c2.nominar(c1);
		c2.nominar(c4);
		assertFalse(c2.cumpleLasReglas());
		
		//Caso 3: solo tiene pretendistas y menores a la puntuacion
		Tronero c6= new Tronero(null, 2);
		Pretendista c5= new Pretendista(null, 0);
		c6.nominar(c5);
		c6.nominar(c4);
		assertTrue(c6.cumpleLasReglas());
		
		//Caso 4: solo tiene troneros y menores a la puntuacion
		Tronero c7= new Tronero(null, 2);
		c7.nominar(c6);
		c7.nominar(c2);
		assertTrue(c7.cumpleLasReglas());
		
		//Caso 5: caso en los que solamente tiene o pretendistas o troneros, pero sobrepasa la puntuacion
		Tronero c8= new Tronero(null, 0);
		Pretendista c9= new Pretendista(null, 0);
		
		c6.nominar(c9);
		assertFalse(c6.cumpleLasReglas());
		
		c7.nominar(c8);
		assertFalse(c7.cumpleLasReglas());
	}

	@Test
	public void testAplicarNominacion() 
	{
		//Al ser un tronero el que nomina la nominación siempre será doble,
		//asi que solo hace falta ver ese caso
		
		//Nominación a tronero
		c1.aplicarNominacion(c2);
		System.out.print("Las nominaciones del concursante deberían ser dos, y el programa muestra: ");
		System.out.print(c2.cuantasNominacionesTiene());
		
		//Nominación a pretendista
		Pretendista c5= new Pretendista(null, 0);
		c1.aplicarNominacion(c5);
		System.out.print("\nLas nominaciones del concursante deberían ser dos, y el programa muestra: ");
		System.out.print(c5.cuantasNominacionesTiene());
	}

	@Test
	public void testTronero() 
	{
		assertNotNull(c1);
		assertNotNull(c2);
	}

	@Test
	public void testEstaEntreSusNominados() 
	{
		Pretendista c3= new Pretendista(null, 0);
		assertFalse(c1.estaEntreSusNominados(c3));
		
		c1.nominar(c3);
		assertTrue(c1.estaEntreSusNominados(c3));
	}

}
