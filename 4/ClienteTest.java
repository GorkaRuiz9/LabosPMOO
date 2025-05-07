package org.pmoo.packlaboratorio4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	Cliente cl1;
	
	
	@Before
	public void setUp() throws Exception 
	{
		cl1=new Cliente(122, "Manu", "6ye8l9", 95.12, false);
	}

	@After
	public void tearDown() throws Exception 
	{
		cl1=null;
	}

	@Test
	public void testCliente() 
	{
		assertNotNull(cl1);
	}

	@Test
	public void testEsPreferente() 
	{
		//No es preferente
		assertFalse(cl1.esPreferente());
		
		//Si es preferente
		Cliente cl2 = new Cliente(0, null, null, 0, true);
		assertTrue(cl2.esPreferente());
	}

	@Test
	public void testTieneMismoId() 
	{
		//Tiene el mismo id
		assertTrue(cl1.tieneMismoId(122));
		
		//No lo tiene
		Cliente cl2 = new Cliente(0, null, null, 0, true);
		assertFalse(cl2.tieneMismoId(122));
		
	}

	@Test
	public void testObtenerSaldo() 
	{
		//Para obtener el saldo es necesario que la clave tecleada sea la correcta
		//el mismo programa se encarga de verificarlo con un método privado
		
		//Para este primer caso la clave es correcta, por tanto se deberia mostrar 95.12
		System.out.print(cl1.obtenerSaldo("6ye8l9"));
		
		//Cambiamos la clave de manera que pasa a ser incorrecta, y devuelve 0.0
		System.out.print(cl1.obtenerSaldo("6yE8l9"));
	}

	@Test
	public void testActualizarSaldo() 
	{
		//Como antes neceista que la clave sea correcta para hacer la transacción
		
		//Para la primera prueba la contraseña es correcta y el saldo es mayor a la cantidad
		//y esta es positiva, por tanto el resultado a aparecer por pantalla sera  Manu 80.0
		cl1.actualizarSaldo("6ye8l9", 15.12);
		
		//Caso contraseña incorrecta, el programa avisa del error
		cl1.actualizarSaldo("6yE8l9", 15.12);
		
		//Caso contraseña correcta pero saldo menor a la cantidad de transacción
		Cliente cl2 = new Cliente(1222, "Sergio", "1234", 123.0, false);
		cl2.actualizarSaldo("1234",1000.32 );
		
		//Caso contraseña correcta pero cantidad de transaccion negativa
		cl2.actualizarSaldo("1234",-1000.32 );
	}

}
