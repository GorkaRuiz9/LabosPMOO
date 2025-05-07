package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaConcursantesTest {

	Tronero c1,c3;
	Pretendista c2,c4;
	ListaConcursantes lista;
	
	@Before
	public void setUp() throws Exception 
	{
		c1= new Tronero("Manuel", 10);
		c2= new Pretendista("Javier", 20);
		c3= new Tronero("María", 30);
		c4= new Pretendista("Sara", 10);
		
		lista= new ListaConcursantes();
		
		lista.anadir(c1);
		lista.anadir(c2);
		lista.anadir(c3);
		lista.anadir(c4);
	}

	@After
	public void tearDown() throws Exception 
	{
		c1=null;
		c2=null;
		c3=null;
		c4=null;
		
		lista= null;
	}

	@Test
	public void testListaConcursantes() 
	{
		assertNotNull(lista);
	}

	@Test
	public void testObtenerConcursanteEnPos() 
	{
		//Caso posicionador correcto; al introducir dos nos deberia devolver c3
		Concursante unConcursante=lista.obtenerConcursanteEnPos(2);
		assertEquals(c3,unConcursante);
		
		//Si ponemos un posicionador incorrecto, en este caso serían
		//los menores a cero o los mayores a tres, el programa avisa de ello
		System.out.print("Para el valor -3 debería indicar que no es correcto: ");
		lista.obtenerConcursanteEnPos(-3);
		System.out.print("\nPara el valor 4 debería indicar que no es correcto: ");
		lista.obtenerConcursanteEnPos(4);
	}

	@Test
	public void testNumeroConcursantes() 
	{
		System.out.print("\nEl número de concursantes es de 4, y el programa muestra: ");
		System.out.print(lista.numeroConcursantes());
		
		//Añadimos un concursante más
		Pretendista c5= new Pretendista(null,0);
		lista.anadir(c5);
		System.out.print("\nEl número de concursantes aumenta en uno por tanto debería mostrarse cinco, y el programa muestra: ");
		System.out.print(lista.numeroConcursantes());
	}

	@Test
	public void testNumeroTroneros() 
	{
		System.out.print("\nEl número de troneros es 2, y el programa muestra: ");
		System.out.print(lista.numeroTroneros());
		
		//Añadimos otro tronero
		Tronero c6= new Tronero(null,0);
		lista.anadir(c6);
		System.out.print("\nEl número de troneros se ha aumentado en uno, por lo cual debería mostrarse tres, y el programa muestra: ");
		System.out.print(lista.numeroTroneros());
		
		//Añadimos un pretendista
		Pretendista c7= new Pretendista(null, 0);
		lista.anadir(c7);
		System.out.print("\nEl número de troneros no se ha aumentado, sino que se ha añadido un pretendista, por lo cual debería mostrarse tres, y el programa muestra: ");
		System.out.print(lista.numeroTroneros());
	}

	@Test
	public void testNumeroPretendistas() 
	{
		System.out.print("\nEl número de pretendistas es 2, y el programa muestra: ");
		System.out.print(lista.numeroPretendistas());
		
		//Añadimos otro pretendista
		Pretendista c6= new Pretendista(null,0);
		lista.anadir(c6);
		System.out.print("\nEl número de pretendistas se ha aumentado en uno, por lo cual debería mostrarse tres, y el programa muestra: ");
		System.out.print(lista.numeroPretendistas());
		
		//Añadimos un tronero
		Tronero c7= new Tronero(null, 0);
		lista.anadir(c7);
		System.out.print("\nEl número de pretendistas no se ha aumentado, sino que se ha añadido un tronero, por lo cual debería mostrarse tres, y el programa muestra: ");
		System.out.print(lista.numeroPretendistas());
	}

	@Test
	public void testAnadir() 
	{
		assertEquals(4,lista.numeroConcursantes());
		Pretendista c7= new Pretendista(null, 0);
		lista.anadir(c7);
		assertEquals(5,lista.numeroConcursantes());
	}

	@Test
	public void testEsta() {
		assertTrue(lista.esta(c1));
		Pretendista c7= new Pretendista(null, 0);
		assertFalse(lista.esta(c7));
	}

}
