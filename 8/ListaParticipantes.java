package org.pmoo.packlaboratorio8;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaParticipantes
{
	// atributos

	private ArrayList<Participante> lista;

	// constructora
	
	/**
	 * post: inicializa la lista de concursantes a una lista vacia
	 */
	public ListaParticipantes() 
	{
		this.lista= new ArrayList<Participante>();
	}

	
	
	/**
	 * 
	 * @return el iterador de la lista de participantes
	 */
	private Iterator<Participante> getIterador() 
	{
		return this.lista.iterator();
	}

	
	
	/**
	 * 
	 * @return el número de participantes que hay en la lista.
	 */
	public int obtenerNumeroDeParticipantes() 
	{
		return this.lista.size();
	}

	
	
	/**
	 * 
	 * @param pId
	 * @return un booleano que indica si existe un participante en la lista cuyo identificador
	 *         es igual a pId.
	 */
	private boolean existeUnParticipanteConEsteId(int pId) 
	{
		boolean rdo=false;
		Participante unParticipante;
		Iterator<Participante> itr= this.getIterador();
		while (itr.hasNext() && !rdo)
		{
			unParticipante=itr.next();
			if (unParticipante.tieneEsteId(pId))
			{
				rdo=true;
			}
		}
		return rdo;
	}

	

	/**
	 * 
	 * @param pNombre
	 * @param pId
	 * @param pEdad
	 * @exception se lanza una YaExisteIdException si en la lista ya hay un participante cuyo
	 *            identificador es pId.
	 *            En este método NO se realiza el tratamiento de MenorDeEdadException.
	 *            Si no ocurre ninguna situación excepcional, se añade a la lista un  participante 
	 *            cuyo nombre es pNombre, su identificador es pId, y su edad es pEdad.
	 *                    
	 */
	public void anadirParticipante(String pNombre, int pId, int pEdad) throws YaExisteIdException,MenorDeEdadException
	{
		if(this.existeUnParticipanteConEsteId(pId))
		{
			throw new YaExisteIdException();
		}
		else
		{
			Participante unParticipante= new Participante(pNombre, pId, pEdad);
			this.lista.add(unParticipante);
		}
	}
	
	

	/**
	 * 
	 * @param pId
	 * @return el participante de la lista cuyo identificador es igual a pId.
	 * @exception se lanza una NoEncontradoException si no existe tal participante.
	 */
	public Participante obtenerParticipanteCuyoIdEs(int pId) throws NoEncontradoException
	{
		Participante unParticipante=null;
		
		if (!this.existeUnParticipanteConEsteId(pId))
		{
			throw new NoEncontradoException();
		}
		else
		{
			boolean rdo=false;
			Iterator<Participante> itr= this.getIterador();
			while (itr.hasNext() && !rdo)
			{
				unParticipante=itr.next();
				if (unParticipante.tieneEsteId(pId))
				{
					rdo=true;
				}
			}
		}
		return unParticipante;
	}
		
	
}

