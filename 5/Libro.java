package org.pmoo.packlaboratorio5;

public class Libro
{
	// atributos
	private String titulo;
	private String autor;
	private int idLibro;
	
	// constructora
	
	public Libro(String pTitulo, String pAutor, int pIdLibro)
	{
		this.titulo=pTitulo;
		this.autor=pAutor;
		this.idLibro=pIdLibro;
	} 
	
	
	//getters
	public int getIdLibro() {
		return idLibro;
	}


	// otros métodos
	
	public boolean tieneEsteId (int pIdLibro)
	{
		if (this.idLibro==pIdLibro)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public boolean tieneElMismoId (Libro pLibro)
	{
		if (this.idLibro==pLibro.getIdLibro())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void imprimir()
	{
		System.out.print("\n* ");
		System.out.print(this.titulo);
		System.out.print(" , escrito por ");
		System.out.print(this.autor);
		System.out.print(".");
	}
}
