package org.pmoo.packlaboratorio5;

public class Usuario
{
	//atributos
	private int idUsuario;
	private String nombreCompleto;
	private int maxLibros;
	private ListaLibros librosEnPrestamo;
	
	//constructora

	public Usuario(String pNombreCompleto, int pIdUsuario)
	{
		this.nombreCompleto=pNombreCompleto;
		this.idUsuario=pIdUsuario;
		this.maxLibros=3;
		this.librosEnPrestamo= new ListaLibros();
	}

	
	// otros métodos

	public Boolean tieneEsteId(int pId)
	{
		if (this.idUsuario==pId)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	


	public Boolean tieneElMismoId(Usuario pUsuario)
	{
		if (pUsuario.tieneEsteId(this.idUsuario))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean haAlcanzadoElMaximo()
	{
		if (this.librosEnPrestamo.obtenerNumLibros()>=this.maxLibros)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void anadirLibro(Libro pLibro)
	{
		this.librosEnPrestamo.anadirLibro(pLibro);
	}

	public void eliminarLibro(Libro pLibro)
	{
		this.librosEnPrestamo.eliminarLibro(pLibro);
	}

	public boolean loTieneEnPrestamo(Libro pLibro)
	{
		return this.librosEnPrestamo.esta(pLibro);
	}

	public void imprimir()
	{
		System.out.print("\nID: ");
		System.out.print(this.idUsuario);
		System.out.print(" :");
		System.out.print(this.nombreCompleto);
		if (this.librosEnPrestamo.obtenerNumLibros()==0)
		{
			System.out.print("\n---> No tiene libros en prestamo.");
		}
		else if (this.librosEnPrestamo.obtenerNumLibros()==1)
		{
			System.out.print("\n---> Tiene el siguiente titulo en prestamo:");
		}
		else
		{
			System.out.print("\n---> Tiene los siguientes ");
			System.out.print(this.librosEnPrestamo.obtenerNumLibros());
			System.out.print(" titulos en prestamo:");
		}
		this.librosEnPrestamo.imprimir();
		
	}

}
