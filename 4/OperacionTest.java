package org.pmoo.packlaboratorio4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OperacionTest {
	Operacion op1;
	ListaClientes lista;
	
	
	@Before
	public void setUp() throws Exception 
	{
		op1=new Operacion(12, 330, "6b1q3", 100);
		lista=ListaClientes.getListaClientes();
	}

	@After
	public void tearDown() throws Exception 
	{
		op1=null;
		lista.resetear();
	}

	@Test
	public void testOperacion() 
	{
		assertNotNull(op1);
	}


	@Test
	public void testTieneMismoId() 
	{
		//Tiene el mismo id
		assertTrue(op1.tieneMismoId(12));
		
		//No tiene el mismo id
		assertFalse(op1.tieneMismoId(12333));
	}

	@Test
	public void testRealizarOperacion() {
		lista.anadirCliente(100, "Sergio", "1ge34tu", 1432.67, false);
		lista.anadirCliente(101, "Alex", "wq4j", 2319.0, true);
		lista.anadirCliente(102, "Carolina", "qo193u", 1762.91, false);
		lista.anadirCliente(103, "Andrea", "1n1l12", 600.12, false);
		lista.anadirCliente(99, "Armando", "1l12", 600.12, false);
		
		//Caso no encuentra el cliente, por tanto no ocurre nada
		Operacion op2= new Operacion(1213, 1090,"wq4j", 100);
		ListaClientes aux=lista;
		op2.realizarOperacion();
		assertEquals(lista,aux);
		
		//Encuentra al cliente, clave correcta, transacción correcta y preferente, por tanto deberia 
		//actualizar saldo imprimiendo por pantalla Alex 2219.0
		Operacion op3= new Operacion(213, 101,"wq4j", 100);
		op3.realizarOperacion();
		
		//Encuentra al cliente, clave correcta, transacción correcta y  no preferente, por tanto deberia 
		//actualizar saldo imprimiendo por pantalla Armando 500.02
		Operacion op7= new Operacion(213, 99,"1l12", 100);
		op7.realizarOperacion();
		
		//Encuentra al cliente, clave incorrecta, el programa debe avisar 
		Operacion op4= new Operacion(89, 102,"jbsj", 10);
		op4.realizarOperacion();
		
		//Encuentra al cliente, clave correcta, saldo menor a transaccion, el programa debe avisar
		Operacion op5= new Operacion(897, 102,"qo193u", 2000);
		op5.realizarOperacion();
		
		//Encuentra al cliente, clave correcta, transacción negativa, el programa debe avisar
		Operacion op6= new Operacion(897, 102,"qo193u", -2000);
		op6.realizarOperacion();
	}

}
