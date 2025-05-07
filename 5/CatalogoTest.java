package org.pmoo.packlaboratorio5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CatalogoTest extends TestCase
{

	private Libro l1;
	private Libro l2;
	private Libro l3;
	private Libro l4;

	private Usuario e1;
	private Usuario e2;

	@Before
	public void setUp()
	{
		l1 = new Libro("ConstrucciÃ³n de software orientado a objetos", "Bertrand Meyer",1);
		l2 = new Libro("Cien aÃ±os de soledad", "Gabriel GarcÃ­a MÃ¡rquez",2); 
		l3 = new Libro("El hobbit", "JRR Tolkien",3);
		l4=  new Libro("El perfume", "Patrick Suskind",4);

		e1=new Usuario("Kepa Sarasola", 2);	
		e2=new Usuario("Armando Guerra", 1);


		Catalogo.getCatalogo().catalogarLibro(l1);
		Catalogo.getCatalogo().catalogarLibro(l2);
		Catalogo.getCatalogo().catalogarLibro(l3);

		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(e1);
		ListaUsuarios.getListaUsuarios().darDeAltaUsuario(e2);

	}

	@After
	public void tearDown()
	{
		l1 = null;
		l2 = null;
		l3 = null;

		e1=null;
		e2=null;

		Catalogo.getCatalogo().resetear();
	}

	@Test
	public void testGetCatalogo()
	{
		assertNotNull(Catalogo.getCatalogo());
	}

	@Test
	public void testBuscarLibroPorId()
	{
		Libro unLibro=Catalogo.getCatalogo().buscarLibroPorId(2);
		assertEquals(unLibro,l2);
		
		Libro dosLibro=Catalogo.getCatalogo().buscarLibroPorId(20910);
		assertNull(dosLibro);
		
		Libro tresLibro=Catalogo.getCatalogo().buscarLibroPorId(1);
		assertEquals(tresLibro,l1);
	}

	@Test
	public void testCatalogarYDescatalogarLibroYResetear()
	{
		//Primero vemos que el catalogo no esta vacio
		int nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(3,nLibros);
				
		//Si reseteamos ese número pasa a ser cero
		Catalogo.getCatalogo().resetear();
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(0,nLibros);
				
		//Vamos añadiendo libros y vemos como ese número aumenta
		Catalogo.getCatalogo().catalogarLibro(l1);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(1,nLibros);
				
		Catalogo.getCatalogo().catalogarLibro(l2);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(2,nLibros);
				
		Catalogo.getCatalogo().catalogarLibro(l3);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(3,nLibros);
				
		//Si intentamos añadir un libro que ya esta este no se añade
		Catalogo.getCatalogo().catalogarLibro(l3);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(3,nLibros);
				
		//Y de igual manera si vamos quitando libros, el número irá reduciendose
		Catalogo.getCatalogo().descatalogarLibro(1);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(2,nLibros);
				
		//Si intentamos descatalogar un libro que no está no ocurre nada
		Catalogo.getCatalogo().descatalogarLibro(1);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(2,nLibros);
				
		Catalogo.getCatalogo().descatalogarLibro(2);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(1,nLibros);
				
		Catalogo.getCatalogo().descatalogarLibro(3);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(0,nLibros);
	}

	@Test
	public void testPrestarYDevolverLibro()
	{
		//Primero vemos cuantos libros tiene el usuario
		System.out.print("El programa debe decir que ninguno de los dos tiene ningun título prestado, y dice:");
		ListaUsuarios.getListaUsuarios().imprimir();
		
		//Tras esta línea deberá tener un libro en su lista
		Catalogo.getCatalogo().prestarLibro(1, 2);
		System.out.print("\nAhora debe decir que Kepa Sarasola tiene un título prestado, mas exactamente ConstrucciÃ³n de software orientado a objetos de Bertrand Meyer");
		ListaUsuarios.getListaUsuarios().imprimir();
		
		//Prestamos un libro al segundo usuario
		Catalogo.getCatalogo().prestarLibro(2, 1);
		System.out.print("\nAhora seguimos en la situación de antes, pero el usuario Armando Guerra tendrá prestado el título: Cien aÃ±os de soledad de Gabriel GarcÃ­a MÃ¡rquez");
		ListaUsuarios.getListaUsuarios().imprimir();
		
		System.out.print("\nPrestamos el libro El Hobbit a Armando Guerra y así debe mostrarse:");
		Catalogo.getCatalogo().prestarLibro(3, 1);
		ListaUsuarios.getListaUsuarios().imprimir();
		
		//Si devolvemos ambos libros volvemos a la situación incial
		Catalogo.getCatalogo().devolverLibro(1);
		Catalogo.getCatalogo().devolverLibro(2);
		Catalogo.getCatalogo().devolverLibro(3);
		System.out.print("\nDebería aparecer la situación incial; ambos con ningún título prestado:");
		ListaUsuarios.getListaUsuarios().imprimir();
		
		//Casos especiales para prestamos
		
		//Caso el libro lo tiene prestado otro usuario
		System.out.print("\nEl programa debe avisar de que ese libro no se puede prestar:");
		Catalogo.getCatalogo().prestarLibro(1, 2);
		Catalogo.getCatalogo().prestarLibro(1, 1);
		
		//Caso tiene el número maximo de libros prestados
		Catalogo.getCatalogo().prestarLibro(2, 2);
		Catalogo.getCatalogo().prestarLibro(3, 2);
		System.out.print("\nEl programa debe avisar de que no puede tener más libros prestados:");
		Catalogo.getCatalogo().prestarLibro(4, 2);
		
		Catalogo.getCatalogo().devolverLibro(1);
		Catalogo.getCatalogo().devolverLibro(2);
		Catalogo.getCatalogo().devolverLibro(3);
		
	}
	
	@Test
	public void testimprimir()
	{
		assertEquals(3,Catalogo.getCatalogo().obtenerNumLibros());

		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del mÃ©todo imprimir de la clase Catalogo");
		System.out.println("\nLa informaciÃ³n de la lista de usuarios deberÃ­a mostrarse de este modo:\n");
		System.out.println("El catÃ¡logo tiene un total de 3 tÃ­tulos.");
		System.out.println("* ConstrucciÃ³n de software orientado a objetos, escrito por Bertrand Meyer.");
		System.out.println("* Cien aÃ±os de soledad, escrito por Gabriel GarcÃ­a MÃ¡rquez.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");

		System.out.println("\nY tu programa lo muestra de este modo:");
		Catalogo.getCatalogo().imprimir();
		System.out.println("\n===============================================================");

		Catalogo.getCatalogo().descatalogarLibro(1);
		Catalogo.getCatalogo().descatalogarLibro(2);
		Catalogo.getCatalogo().descatalogarLibro(3);
		assertEquals(0,Catalogo.getCatalogo().obtenerNumLibros());	

		

	}

}
