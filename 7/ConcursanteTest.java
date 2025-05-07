package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConcursanteTest {

	Tronero c1;
	Pretendista c2;
	
	@Before
	public void setUp() throws Exception 
	{
		c1= new Tronero("Manu", 10);
		c2= new Pretendista("Javier", 5);
	}

	@After
	public void tearDown() throws Exception 
	{
		c1=null;
		c2=null;
	}

	@Test
	public void testConcursante() 
	{
		assertNotNull(c1);
		assertNotNull(c2);
	}

	@Test
	public void testObtenerNombre() 
	{
		String unNombre= c1.obtenerNombre();
		assertEquals("Manu",unNombre);
	}

	@Test
	public void testObtenerPuntuacion() 
	{
		int unaPuntuacion= c1.obtenerPuntuacion();
		assertEquals(10,unaPuntuacion);
	}

	@Test
	public void testObtenerListaNominados() 
	{
		ListaConcursantes lista=c1.obtenerListaNominados();
		assertNotNull(lista);
		
	}

	@Test
	public void testPonerACeroSusNominaciones() 
	{
		c1.incrementarNominacionesRecibidas(3);
		assertNotEquals(0,c1.cuantasNominacionesTiene());
		
		c1.ponerACeroSusNominaciones();
		assertEquals(0,c1.cuantasNominacionesTiene());
	}

	@Test
	public void testCuantasNominacionesTiene() 
	{
		assertEquals(0,c1.cuantasNominacionesTiene());
		
		c1.incrementarNominacionesRecibidas(2);
		assertEquals(2,c1.cuantasNominacionesTiene());
		
		c1.incrementarNominacionesRecibidas(20);
		assertEquals(22,c1.cuantasNominacionesTiene());
	}

	@Test
	public void testIncrementarNominacionesRecibidas() 
	{
		assertEquals(0,c1.cuantasNominacionesTiene());
		
		c1.incrementarNominacionesRecibidas(2);
		assertEquals(2,c1.cuantasNominacionesTiene());
		
		c1.incrementarNominacionesRecibidas(20);
		assertEquals(22,c1.cuantasNominacionesTiene());
	}

	@Test
	public void testNumeroDeTronerosQueHaNominado() 
	{
		c2.nominar(c1);
		assertEquals(1,c2.numeroDeTronerosQueHaNominado());
		
		Tronero c3=new Tronero(null, 0);
		Pretendista c4=new Pretendista(null, 0);
		
		c2.nominar(c3);
		c2.nominar(c4);
		
		assertEquals(2,c2.numeroDeTronerosQueHaNominado());
	}

	@Test
	public void testNumeroDePretendistasQueHaNominado() 
	{
		c1.nominar(c2);
		assertEquals(1,c1.numeroDePretendistasQueHaNominado());
		
		Tronero c3=new Tronero(null, 0);
		Pretendista c4=new Pretendista(null, 0);
		
		c1.nominar(c3);
		c1.nominar(c4);
		
		assertEquals(2,c1.numeroDePretendistasQueHaNominado());
	}

	@Test
	public void testNominar() 
	{
		//La suma de troneros y pretendistas es el número total de la lista de nominados
		assertEquals(0,c1.numeroDePretendistasQueHaNominado()+c1.numeroDeTronerosQueHaNominado());
		
		c1.nominar(c2);
		assertEquals(1,c1.numeroDePretendistasQueHaNominado()+c1.numeroDeTronerosQueHaNominado());
		
		Tronero c3=new Tronero(null, 0);
		Pretendista c4=new Pretendista(null, 0);
		
		c1.nominar(c3);
		c1.nominar(c4);
		
		assertEquals(3,c1.numeroDePretendistasQueHaNominado()+c1.numeroDeTronerosQueHaNominado());
	}

	@Test
	public void testAplicarNominaciones() 
	{
		//Solamente necesitamos ver que se recorre bien la lista y se ejecuta
		//para cada elemento, ya que las características de las nominaciones vienen dadas en otras pruebas
		c1.nominar(c2);
		
		Tronero c3=new Tronero(null, 0);
		c1.nominar(c3);
		
		c1.aplicarNominaciones();
		
		System.out.print("El programa debe mostrar 2, y muestra: ");
		System.out.print(c2.cuantasNominacionesTiene());
		
		System.out.print("\nEl programa debe mostrar 2, y muestra: ");
		System.out.print(c3.cuantasNominacionesTiene());
		
		Pretendista c4=new Pretendista(null, 0);
		
		c2.nominar(c4);
		c2.nominar(c3);
		c3.nominar(c2);
		
		c2.aplicarNominaciones();
		
		System.out.print("\nEl programa debe mostrar 1, y muestra: ");
		System.out.print(c4.cuantasNominacionesTiene());
		
		System.out.print("\nEl programa debe mostrar 7, y muestra: ");
		System.out.print(c3.cuantasNominacionesTiene());
	}

	@Test
	public void testCumpleLasReglas() 
	{
		//Las pruebas estan en las respectivas subclases
	}

	@Test
	public void testAplicarNominacion() 
	{
		//Las pruebas estan en las respectivas subclases
	}

}
