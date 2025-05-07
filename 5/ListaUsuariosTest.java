package org.pmoo.packlaboratorio5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ListaUsuariosTest extends TestCase
{

	private Usuario u1;
	private Usuario u2;
	private Usuario u3;
	
	private Libro l1;
	private Libro l2;
	private Libro l3;
	
	ListaUsuarios lista;
	ListaUsuarios lista2;
	
	@Before
	public void setUp()
	{
		u1 = new Usuario("Armando Guerra", 1);
		u2 = new Usuario("Kepa Sarasola", 2); 
		u3 = new Usuario("Lola Mento", 3);

		l1=new Libro("Cumbres borrascosas","Emily Bronte",1);
		l2=new Libro("Sentido y sensibilidad","Jane Austen",2);
		l3 = new Libro("El hobbit", "JRR Tolkien",3);
		
	}

	@After
	public void tearDown()
	{
		u1 = null;
		u2 = null;
		u3 = null;
		ListaUsuarios.getListaUsuarios().resetear();
	}

	@Test
	public void testGetListaUsuarios()
	{
		lista=lista.getListaUsuarios();
		assertNotNull(lista);
		
		//Aeguramos que haya una �nica instancia
		lista2=lista2.getListaUsuarios();
		assertEquals(lista,lista2);
	}

	@Test
	public void testBuscarUsuarioPorId()
	{
		lista=lista.getListaUsuarios();
		lista.darDeAltaUsuario(u1);
		lista.darDeAltaUsuario(u2);
		lista.darDeAltaUsuario(u3);
		
		Usuario unUsuario=lista.buscarUsuarioPorId(1);
		//La id marcada es del u3, por la tanto deberian ser igualea
		
		assertEquals(u1,unUsuario);
		
		Usuario dosUsuario=lista.buscarUsuarioPorId(2);
		
		assertEquals(u2,dosUsuario);
		
		Usuario tresUsuario=lista.buscarUsuarioPorId(10000);
		assertEquals(null,tresUsuario);
	}

	@Test
	public void testExisteUsuarioConMismoId()
	{
		lista=lista.getListaUsuarios();
		
		assertFalse(lista.existeUnUsuarioConMismoId(u1));
		
		lista.darDeAltaUsuario(u1);
		
		assertTrue(lista.existeUnUsuarioConMismoId(u1));
		assertFalse(lista.existeUnUsuarioConMismoId(u2));
		
		lista.darDeAltaUsuario(u2);
		assertTrue(lista.existeUnUsuarioConMismoId(u2));
	}

	@Test
	public void testAnadirYdarDeBajaUsuarioYResetear()
	{
		lista=lista.getListaUsuarios();
		assertEquals(0,lista.obtenerNumUsuarios());
		
		lista.darDeAltaUsuario(u1);
		assertEquals(1,lista.obtenerNumUsuarios());
		
		lista.darDeAltaUsuario(u2);
		assertEquals(2,lista.obtenerNumUsuarios());
		
		lista.darDeBajaUsuario(1);
		assertEquals(1,lista.obtenerNumUsuarios());
		
		lista.resetear();
		assertEquals(0,lista.obtenerNumUsuarios());
		
	}

	@Test
	public void testDarAltaYBajaUsuarioYEsta()
	{
		lista=lista.getListaUsuarios();
		
		lista.darDeAltaUsuario(u1);
		lista.darDeAltaUsuario(u2);
		
		assertNotNull(lista.buscarUsuarioPorId(1));
		assertNull(lista.buscarUsuarioPorId(10000));
		
		lista.darDeBajaUsuario(1);
		assertNull(lista.buscarUsuarioPorId(1));
		
		//Si queremos dar de alta a alguien con mismo id que alguien dado de alta el programa avisar�
		Usuario unUsuario=new Usuario(getName(), 2);
		System.out.print("El programa debe decir que ya existe un usuario con ese id: ");
		lista.darDeAltaUsuario(unUsuario);
	}

	@Test
	public void testQuienLoTienePrestado()
	{
		lista=lista.getListaUsuarios();
		u1.anadirLibro(l1);
		u2.anadirLibro(l2);
		u3.anadirLibro(l3);
		lista.darDeAltaUsuario(u1);
		lista.darDeAltaUsuario(u2);
		lista.darDeAltaUsuario(u3);
		
		Usuario unUsuario=lista.quienLoTienePrestado(l1);
		assertEquals(unUsuario,u1);
		
		Usuario dosUsuario=lista.quienLoTienePrestado(l2);
		assertEquals(dosUsuario,u2);
		
		Usuario tresUsuario=lista.quienLoTienePrestado(l3);
		assertEquals(tresUsuario,u3);
		
	}

	@Test		
	public void testImprimir()
	{

		assertNotNull(ListaUsuarios.getListaUsuarios());		

		u1.anadirLibro(l1);
		u3.anadirLibro(l2);
		u3.anadirLibro(l3);

		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u1);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u2);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(u3);

		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase ListaUsuarios");
		System.out.println("\nLa información de la lista de usuarios debería mostrarse de este modo:\n");

		System.out.println("Hay un total de 3 usuarios.");
		System.out.println("ID: 1: Armando Guerra");
		System.out.println("---> Tiene el siguiente título en préstamo:");
		System.out.println("* Cumbres borrascosas, escrito por Emily Bronte.");
		System.out.println("ID: 2: Kepa Sarasola");
		System.out.println("---> No tiene libros en préstamo.");
		System.out.println("ID: 3: Lola Mento");
		System.out.println("---> Tiene los siguientes 2 títulos en préstamo:");
		System.out.println("* Sentido y sensibilidad, escrito por Jane Austen.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");

		System.out.println("\nY tu programa lo muestra de este modo:");
		ListaUsuarios.getListaUsuarios().imprimir();
		System.out.println("\n===============================================================");

		ListaUsuarios.getListaUsuarios().darDeBajaUsuario(1);
		ListaUsuarios.getListaUsuarios().darDeBajaUsuario(2);
		ListaUsuarios.getListaUsuarios().darDeBajaUsuario(3);
		assertEquals(0,ListaUsuarios.getListaUsuarios().obtenerNumUsuarios());	

	}

}

