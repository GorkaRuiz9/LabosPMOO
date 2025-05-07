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
		l1 = new Libro("Construcción de software orientado a objetos", "Bertrand Meyer",1);
		l2 = new Libro("Cien años de soledad", "Gabriel García Márquez",2); 
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
				
		//Si reseteamos ese n�mero pasa a ser cero
		Catalogo.getCatalogo().resetear();
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(0,nLibros);
				
		//Vamos a�adiendo libros y vemos como ese n�mero aumenta
		Catalogo.getCatalogo().catalogarLibro(l1);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(1,nLibros);
				
		Catalogo.getCatalogo().catalogarLibro(l2);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(2,nLibros);
				
		Catalogo.getCatalogo().catalogarLibro(l3);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(3,nLibros);
				
		//Si intentamos a�adir un libro que ya esta este no se a�ade
		Catalogo.getCatalogo().catalogarLibro(l3);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(3,nLibros);
				
		//Y de igual manera si vamos quitando libros, el n�mero ir� reduciendose
		Catalogo.getCatalogo().descatalogarLibro(1);
		nLibros=Catalogo.getCatalogo().obtenerNumLibros();
		assertEquals(2,nLibros);
				
		//Si intentamos descatalogar un libro que no est� no ocurre nada
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
		System.out.print("El programa debe decir que ninguno de los dos tiene ningun t�tulo prestado, y dice:");
		ListaUsuarios.getListaUsuarios().imprimir();
		
		//Tras esta l�nea deber� tener un libro en su lista
		Catalogo.getCatalogo().prestarLibro(1, 2);
		System.out.print("\nAhora debe decir que Kepa Sarasola tiene un t�tulo prestado, mas exactamente Construcción de software orientado a objetos de Bertrand Meyer");
		ListaUsuarios.getListaUsuarios().imprimir();
		
		//Prestamos un libro al segundo usuario
		Catalogo.getCatalogo().prestarLibro(2, 1);
		System.out.print("\nAhora seguimos en la situaci�n de antes, pero el usuario Armando Guerra tendr� prestado el t�tulo: Cien años de soledad de Gabriel García Márquez");
		ListaUsuarios.getListaUsuarios().imprimir();
		
		System.out.print("\nPrestamos el libro El Hobbit a Armando Guerra y as� debe mostrarse:");
		Catalogo.getCatalogo().prestarLibro(3, 1);
		ListaUsuarios.getListaUsuarios().imprimir();
		
		//Si devolvemos ambos libros volvemos a la situaci�n incial
		Catalogo.getCatalogo().devolverLibro(1);
		Catalogo.getCatalogo().devolverLibro(2);
		Catalogo.getCatalogo().devolverLibro(3);
		System.out.print("\nDeber�a aparecer la situaci�n incial; ambos con ning�n t�tulo prestado:");
		ListaUsuarios.getListaUsuarios().imprimir();
		
		//Casos especiales para prestamos
		
		//Caso el libro lo tiene prestado otro usuario
		System.out.print("\nEl programa debe avisar de que ese libro no se puede prestar:");
		Catalogo.getCatalogo().prestarLibro(1, 2);
		Catalogo.getCatalogo().prestarLibro(1, 1);
		
		//Caso tiene el n�mero maximo de libros prestados
		Catalogo.getCatalogo().prestarLibro(2, 2);
		Catalogo.getCatalogo().prestarLibro(3, 2);
		System.out.print("\nEl programa debe avisar de que no puede tener m�s libros prestados:");
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
		System.out.println("\nCaso de prueba del método imprimir de la clase Catalogo");
		System.out.println("\nLa información de la lista de usuarios debería mostrarse de este modo:\n");
		System.out.println("El catálogo tiene un total de 3 títulos.");
		System.out.println("* Construcción de software orientado a objetos, escrito por Bertrand Meyer.");
		System.out.println("* Cien años de soledad, escrito por Gabriel García Márquez.");
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
