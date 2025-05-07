package org.pmoo.packlaboratorio5;

public class Catalogo
{
	// atributos
	
	private ListaLibros lista;
	private static Catalogo miCatalogo;
	
	
	// constructora
	
	private Catalogo()
	{ 
		this.lista=new ListaLibros();
	}
	
 	// otros mÃ©todos
	
 	public static Catalogo getCatalogo() 
	{
 		{ 
 			if (miCatalogo==null)
 			{
 				miCatalogo=new Catalogo();
 			}
 			return miCatalogo;
 		}
	}

 	public int obtenerNumLibros()
 	{
 	  return this.lista.obtenerNumLibros();
 	}
 	 	
 	public Libro buscarLibroPorId(int pIdLibro)
 	{
 	  return this.lista.buscarLibroPorId(pIdLibro);
 	}
 	
 	public void prestarLibro(int pIdLibro, int pIdUsuario)
	{
		Libro unLibro=this.lista.buscarLibroPorId(pIdLibro);
		Usuario unUsuario=ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(pIdUsuario);
		
		if (unUsuario.haAlcanzadoElMaximo())
		{
			System.out.print("Ha alcanzado el máximo de libros");
		}
		else if (ListaUsuarios.getListaUsuarios().quienLoTienePrestado(unLibro)!=null)
		{
			System.out.print("Otro usuario lo tiene prestado");
		}
		else
		{
		unUsuario.anadirLibro(unLibro);
		}
	}

 	public void devolverLibro(int pIdLibro)
	{
 		ListaUsuarios miListaUsuarios=null;
		miListaUsuarios=miListaUsuarios.getListaUsuarios();
		Libro unLibro=this.lista.buscarLibroPorId(pIdLibro);
		Usuario unUsuario=miListaUsuarios.quienLoTienePrestado(unLibro);
		unUsuario.eliminarLibro(unLibro);
	}
 	
 	public void catalogarLibro(Libro pLibro)
	{
 		if (this.lista.existeUnLibroConMismoId(pLibro))
 		{
 			System.out.print("Existe otro libro con ese id, por tanto no se puede aññadir");
 		}
 		else
 		{
 		this.lista.anadirLibro(pLibro);
 		}
 	}

 	public void descatalogarLibro(int pIdLibro)
 	{
 		ListaUsuarios miListaUsuarios=null;
		miListaUsuarios=miListaUsuarios.getListaUsuarios();
 		Libro unLibro=this.lista.buscarLibroPorId(pIdLibro);
 		
 		if (miListaUsuarios.quienLoTienePrestado(unLibro)!=null)
 		{
 			System.out.print("Otro usuario lo tiene prestado, por lo que no puede descatalogarse");
 		}
 		else
 		{
 		this.lista.eliminarLibro(unLibro);
 		}
	}

 	public void imprimir()
 	{
 		System.out.print("El catálogo tiene un total de ");
 		System.out.print(this.obtenerNumLibros());
 		System.out.print(" títulos.");
 		this.lista.imprimir();
 	}

 	public void resetear()
 	{
 		this.lista=new ListaLibros();
 	}
	
}	
