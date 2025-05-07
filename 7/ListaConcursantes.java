package org.pmoo.packlaboratorio7;

import java.util.*;

public class ListaConcursantes
{
	// atributos
	private ArrayList<Concursante> lista;
	
	// constructora
	
	/**
	 * post: inicializa la lista de concursantes a una lista vacia
	 */
	public ListaConcursantes()
	{
		this.lista= new ArrayList<Concursante>();
	}
	
	// otros metodos
	
	/**
	 * @return el concursantes que ocupa la posicion pPos de la lista
	 *   post: si el parametro pPos no es valido, se muestra un mensaje por pantalla y se devuelve null.
	 *         Las posiciones de la lista se cuentan empezando en 0 y terminando en n-1, siendo n el numero
	 *         de concursantes que hay en ella.
	 *         
	 */
	public Concursante obtenerConcursanteEnPos(int pPos)
	{
		if (pPos>-1 && pPos<this.numeroConcursantes())
		{
			return this.lista.get(pPos);
		}
		else
		{
			System.out.print("El parámetro pPos no es válido");
			return null;
		}
	}
	
	/**
	 * @return el numero de concursantes que hay en la lista
	 */
	public int numeroConcursantes()
	{
		return this.lista.size();
	}

		
	/**
	 * @return el numero concursantes Troneros que hay en la lista
	 */
	public int numeroTroneros()
	{
		int contador=0;
		int nTroneros=0;
		while (contador<this.numeroConcursantes())
		{
			Concursante unConcursante=this.obtenerConcursanteEnPos(contador);
			contador=contador+1;
			if (unConcursante instanceof Tronero)
			{
				nTroneros=nTroneros+1;
			}
		}
		return nTroneros;
	}
	
	/**
	 * @return el numero concursantes Pretendistas que hay en la lista
	 */
	public int numeroPretendistas()
	{
		int contador=0;
		int nPretendistas=0;
		while (contador<this.numeroConcursantes())
		{
			Concursante unConcursante=this.obtenerConcursanteEnPos(contador);
			contador=contador+1;
			if (unConcursante instanceof Pretendista)
			{
				nPretendistas=nPretendistas+1;
			}
		}
		return nPretendistas;
	}
	
	/**
	 * @param pConcursante
	 *            post: annade el concursante pConcursante a la lista
	 */
	public void anadir(Concursante pConcursante)
	{
		this.lista.add(pConcursante);
	}

	/**
	 * @param pConcursante
	 * @return un booleano que indica si pConcursante esta en la lista de concursantes
	 */
	public boolean esta(Concursante pConcursante)
	{
		int contador=0;
		boolean chivato=false;
		while (contador<this.numeroConcursantes() && !chivato)
		{
			Concursante unConcursante=this.obtenerConcursanteEnPos(contador);
			contador=contador+1;
			if (unConcursante==pConcursante)
			{
				chivato=true;
			}
		}
		return chivato;
	}
}
