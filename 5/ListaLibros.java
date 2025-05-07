package org.pmoo.packlaboratorio5;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaLibros
{
	// atributos
	private ArrayList<Libro> lista;

	// constructora

	public ListaLibros()
	{
		this.lista=new ArrayList<Libro>();
	}

	// otros métodos

	public int obtenerNumLibros()
	{  
		return this.lista.size();
	}

	private Iterator<Libro> getIterador()
	{
		return this.lista.iterator();
	}

	public Libro buscarLibroPorId(int pIdLibro)
	{
		Iterator<Libro> itr=this.getIterador();
		Libro unLibro=null;
		boolean chivato=false;
		while (itr.hasNext() && !chivato)
		{
			unLibro=itr.next();
			if (unLibro.tieneEsteId(pIdLibro))
			{
				chivato=true;
				return unLibro;
			}
			else
			{
				unLibro=null;
			}
			
		}
		return unLibro;
	}
	
	public boolean esta(Libro pLibro)
	{
		Iterator<Libro> itr=this.getIterador();
		Libro unLibro;
		boolean chivato=false;
		while (itr.hasNext() && !chivato)
		{
			unLibro=itr.next();
			if (unLibro.tieneElMismoId(pLibro))
			{
				chivato=true;
			}
			
		}
		return chivato;
	}

	public boolean existeUnLibroConMismoId(Libro pLibro)
	{
		Iterator<Libro> itr=this.getIterador();
		Libro unLibro;
		boolean chivato=false;
		while (itr.hasNext() && !chivato)
		{
			unLibro=itr.next();
			if (unLibro.tieneElMismoId(pLibro))
			{
				chivato=true;
			}
		}
		return chivato;
	}
	
	public void anadirLibro(Libro pLibro)
	{
		if (!this.esta(pLibro))
		{
		this.lista.add(pLibro);
		}
	}

	public void eliminarLibro(Libro pLibro)
	{
		this.lista.remove(pLibro);
	}
	
	public void imprimir()
	{
		Iterator<Libro> itr=this.getIterador();
		Libro unLibro;
		while (itr.hasNext())
		{
			unLibro=itr.next();
			unLibro.imprimir();
		}
	}
}
