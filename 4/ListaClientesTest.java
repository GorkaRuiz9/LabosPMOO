package org.pmoo.packlaboratorio4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaClientesTest {
	ListaClientes lista;
	ListaClientes lista2;
	
	@Before
	public void setUp() throws Exception 
	{
		lista=ListaClientes.getListaClientes();
	}

	@After
	public void tearDown() throws Exception {
		lista.resetear();
	}


	@Test
	public void testGetListaClientes() 
	{
		lista=lista.getListaClientes();
		assertNotNull(lista);
		lista.anadirCliente(1, "Manolo", null, 0, false);
		lista2=lista.getListaClientes();
		
		//Podemos asegurar que solamente hay una unica instancia
		assertEquals(lista,lista2);
		
	}

	@Test
	public void testCantidadClientes() 
	{
		//La lista tiene 0 elementos
		assertEquals(0,lista.cantidadClientes());
		
		//La lista va a tener un elemento más
		lista.anadirCliente(0, null, null, 0, false);
		assertEquals(1,lista.cantidadClientes());
		
		//La lista tendrá dos elementos más 1+2=3
		lista.anadirCliente(11, null, null, 0, false);
		lista.anadirCliente(12, null, null, 0, false);
		assertEquals(3,lista.cantidadClientes());
		
		//Si añadimos un cliente con mismo id no se añade a la lista
		lista.anadirCliente(12, null, null, 0, false);
		assertEquals(3,lista.cantidadClientes());
	}

	@Test
	public void testAnadirCliente() 
	{
		//Al añadir clientes iremos viendo que el tamaño de la lista va cambiando
		lista.anadirCliente(0, null, null, 0, false);
		assertEquals(1,lista.cantidadClientes());
		
		lista.anadirCliente(10, null, null, 0, false);
		assertEquals(2,lista.cantidadClientes());
		
		//Eso si, el id debe ser diferente ya que sino no añadirá a la persona
		//Por tanto si probamos así el tamaño de la lista no cambia
		lista.anadirCliente(0, null, null, 0, false);
		assertEquals(2,lista.cantidadClientes());
		lista.anadirCliente(0, null, null, 0, false);
		assertEquals(2,lista.cantidadClientes());
	}

	@Test
	public void testBuscarClientePorId() 
	{
		lista.anadirCliente(1, "Javier", null, 0, false);
		lista.anadirCliente(2, "Hugo", null, 0, false);
		lista.anadirCliente(3, "Martin", null, 0, false);
		lista.anadirCliente(4, "Asier", null, 0, false);
		lista.anadirCliente(5, "Unai", null, 0, false);
		
		//El id está en la lista y por tanto devuelve un cliente
		
		Cliente Cliente=lista.buscarClientePorId(3);
		//Por tanto deveria devolver el cliente de nombre Martin, 
		//para ello dibujamos por la consola el nombre del cliente devuelto, que deberia ser Martin
		System.out.print(Cliente.getNombre());
		
		//El id no esta por tanto devuelve null
		Cliente Cliente2=lista.buscarClientePorId(31);
		assertNull(Cliente2);
	}

	
}
