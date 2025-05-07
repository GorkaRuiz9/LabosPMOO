package org.pmoo.packlaboratorio4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaOperacionesTest {
	ListaOperaciones lista;
	ListaOperaciones lista2;
	ListaClientes listaC;
	
	@Before
	public void setUp() throws Exception 
	{
		lista=lista.getListaOperaciones();
		listaC=ListaClientes.getListaClientes();
	}

	@After
	public void tearDown() throws Exception 
	{
		lista.resetear();
		listaC.resetear();
	}

	@Test
	public void testGetListaOperaciones() 
	{
		lista=lista.getListaOperaciones();
		assertNotNull(lista);
		lista.anadirOperacion(0, 0, null, 0);
		lista2=lista.getListaOperaciones();
		
		//Podemos asegurar que solamente hay una unica instancia
		assertEquals(lista,lista2);
	}

	@Test
	public void testCantidadOperaciones() 
	{
		//La lista tiene 0 elementos
		assertEquals(0,lista.cantidadOperaciones());
				
		//La lista va a tener un elemento más
		lista.anadirOperacion(0, 0, null, 0);
		assertEquals(1,lista.cantidadOperaciones());
				
		//La lista tendrá dos elementos más 1+2=3
		lista.anadirOperacion(10, 0, null, 0);
		lista.anadirOperacion(11, 0, null, 0);
		assertEquals(3,lista.cantidadOperaciones());
	}

	@Test
	public void testAnadirOperacion() 
	{
		//Al añadir clientes iremos viendo que el tamaño de la lista va cambiando
		lista.anadirOperacion(0, 0, null, 0);
		assertEquals(1,lista.cantidadOperaciones());
		
		lista.anadirOperacion(01, 0, null, 0);
		assertEquals(2,lista.cantidadOperaciones());
		
		//Eso si, el id debe ser diferente ya que sino no añadirá a la persona
		//Por tanto si probamos así el tamaño de la lista no cambia
		lista.anadirOperacion(0, 0, null, 0);
		assertEquals(2,lista.cantidadOperaciones());
		lista.anadirOperacion(0, 0, null, 0);
		assertEquals(2,lista.cantidadOperaciones());
	}

	@Test
	public void testBuscarOperacionPorId() 
	{
		lista.anadirOperacion(1, 111, null, 0);
		lista.anadirOperacion(2, 222, null, 0);
		lista.anadirOperacion(3, 333, null, 0);
		lista.anadirOperacion(4, 444, null, 0);
		lista.anadirOperacion(5, 555, null, 0);
		
		//El id está en la lista y por tanto devuelve un cliente
		
		Operacion Operacion=lista.buscarOperacionPorId(3);
		//Por tanto deveria devolver el id 333,
		//para ello dibujamos por la consola el id de la operacion devuelta, que deberia ser 333
		System.out.print(Operacion.getIdCliente());
		
		//El id no esta por tanto devuelve null
		Operacion Operacion2=lista.buscarOperacionPorId(31);
		assertNull(Operacion2);
	}

	@Test
	public void testRealizarOperaciones()
	{
		listaC.anadirCliente(100, "Sergio", "1ge34tu", 1432.67, false);
		listaC.anadirCliente(101, "Alex", "wq4j", 2319.0, true);
		listaC.anadirCliente(102, "Carolina", "qo193u", 1762.91, false);
		listaC.anadirCliente(103, "Andrea", "1n1l12", 600.12, false);
		listaC.anadirCliente(106, "Armando", "1l12", 600.12, false);
		
		lista.anadirOperacion(1213, 1090,"wq4j", 100);
		lista.anadirOperacion(213, 101,"wq4j", 100);
		lista.anadirOperacion(897, 102,"qo193u", -2000);
		lista.anadirOperacion(89, 102,"jbsj", 10);

		
		
		//Debido a que este método lo que hace es un bucle de RealizarOperacion, para ver
		//que funciona es suficiente con ver que todas las entradas se han ejecutado.
		//Si queremos ver cada situación específica que puede ocurrir tendríamos que mirar
		//las pruebas de realizar operación
		
		lista.realizarOperaciones();
		
		
		
		
	}

}
