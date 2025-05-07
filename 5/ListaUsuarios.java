package org.pmoo.packlaboratorio5;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaUsuarios
{
	// atributos
	private ArrayList<Usuario> lista;
	private static ListaUsuarios miListaUsuarios;

	// constructora

	private ListaUsuarios()
	{ 
		this.lista=new ArrayList<Usuario>();
	}

	// otros métodos

	public static ListaUsuarios getListaUsuarios()
	{ 
		if (miListaUsuarios==null)
		{
			miListaUsuarios=new ListaUsuarios();
		}
		return miListaUsuarios;
	}

	public int obtenerNumUsuarios()
	{
		return this.lista.size();
	}

	private Iterator<Usuario> getIterador()
	{
		return this.lista.iterator();
	}

	public Usuario buscarUsuarioPorId(int pId)
	{
		Usuario unUsuario=null;
		boolean chivato=false;
		Iterator<Usuario> itr=this.getIterador();
		while (itr.hasNext() && !chivato)
		{
			unUsuario=itr.next();
			if (unUsuario.tieneEsteId(pId))
			{
				chivato=true;
			}
		}
		if (!chivato)
		{
			unUsuario=null;
		}
		
		
		return unUsuario;
	}
	

	public Boolean existeUnUsuarioConMismoId(Usuario pUsuario)
	{
		Usuario unUsuario;
		Boolean chivato=false;
		Iterator<Usuario> itr=this.getIterador();
		while (itr.hasNext())
		{
			unUsuario=itr.next();
			if (unUsuario.tieneElMismoId(pUsuario))
			{
				chivato=true;
			}
		}
		return chivato;
	}

	public void darDeAltaUsuario(Usuario pUsuario)
	{
		if (!this.existeUnUsuarioConMismoId(pUsuario))
		{
			this.lista.add(pUsuario);
		}
		else 
		{
			System.out.print("Ya existe un usuario con ese id.");
		}
	}

	public void darDeBajaUsuario(int pIdUsuario)
	{
		Usuario unUsuario=this.buscarUsuarioPorId(pIdUsuario);
		this.lista.remove(unUsuario);
	}

	public Usuario quienLoTienePrestado(Libro pLibro)
	{
		Iterator<Usuario> itr=this.getIterador();
		Usuario unUsuario=null;
		boolean chivato=false;
		while (itr.hasNext() && !chivato)
		{
			unUsuario=itr.next();
			if (unUsuario.loTieneEnPrestamo(pLibro))
			{
				chivato=true;
				return unUsuario;
			}
			else
			{
				unUsuario=null;
			}
		}
		return unUsuario;
	}

	public void imprimir()
	{	
		System.out.print("Hay un total de ");
		System.out.print(this.obtenerNumUsuarios());
		System.out.print(" usuarios.");
		Iterator<Usuario> itr=this.getIterador();
		Usuario unUsuario;
		while (itr.hasNext())
		{
			unUsuario=itr.next();
			unUsuario.imprimir();
		}
	}

	public void resetear()
	{
		this.lista.clear();
	}


}
