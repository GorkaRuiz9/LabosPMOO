package org.pmoo.packlaboratorio7;

import java.util.*;

public class Roster
{
	// atributos
	private ArrayList<Concursante> lista;
	private static Roster miRoster;

	// constructora
	private Roster()
	{
		this.lista=new ArrayList<Concursante>();
	}

	// otros metodos
	
	/**
	 * @return la unica instancia del Roster
	 */
	public static Roster getRoster()
	{
		if (miRoster==null)
		{
			miRoster=new Roster();
		}
		return miRoster;
	}

	/**
	 * 
	 * @return el iterador del Roster de concursantes
	 */
	private Iterator<Concursante> getIterador()
	{
		return this.lista.iterator();
	}
	
	/**
	 * 
	 * @param pNombre
	 * @return el concursante del Roster cuyo nombre es igual a pNnombre
	 *         Si no existe tal concursante, se devuelve null
	 */
	private Concursante buscarConcursantePorNombre(String pNombre)
	{
		Iterator<Concursante> itr=this.getIterador();
		Concursante unConcursante;
		Concursante okConcursante=null;
		boolean chivato=false;
		while (itr.hasNext() && !chivato)
		{
			unConcursante=itr.next();
			if (unConcursante.obtenerNombre()==pNombre)
			{
				chivato=true;
				okConcursante=unConcursante;
			}
		}
		return okConcursante;
	}
	
	/**
	 * 
	 * @param pConcursante
	 *   post: se annade al Roster al concursante pConcursante, salvo que ya exista un concursante
	 *         con el mismo nombre que pConcursante, en cuyo caso no se annade y se muestra un mensaje
	 *         por pantalla.            
	 */
	public void anadirConcursante(Concursante pConcursante)
	{
		this.lista.add(pConcursante);
	}
	/**
	 * 
	 * @return un booleano que indica si, para todos los concursantes del roster, su lista
	 *         de nominados cumple las reglas definidas en el enunciado.  
	 *        
	 */
	private boolean seCumplenLasReglas()
	{
		Iterator<Concursante> itr=this.getIterador();
		Concursante unConcursante;
		boolean chivato=true;
		
		while (itr.hasNext() && chivato)
		{
			unConcursante=itr.next();
			if (!unConcursante.cumpleLasReglas())
			{
				chivato=false;
			}
		}
		return chivato;
	}

	/**
	 * @return el umbral para entrar en la lista de concursantes expulsables, es decir, el numero
	 *         maximo de nominaciones recibidas por un concursante de tipo Tronero 	 *       
	 */
	private int calcularUmbral()
	{
		Iterator<Concursante> itr=this.getIterador();
		Concursante unConcursante;
		int umbral=0;
		
		while (itr.hasNext())
		{
			unConcursante=itr.next();
			if (unConcursante instanceof Tronero)
			{
				if (unConcursante.cuantasNominacionesTiene()>umbral)
				{
					umbral=unConcursante.cuantasNominacionesTiene();
				}
			}
		}
		return umbral;
	}

	/**
	 * @return la lista de concursantes expulsables, segun lo expuesto en el enunciado. 
	 *       
	 */
	public ListaConcursantes obtenerListaDeConcursantesExpulsables()
	{
		Iterator<Concursante> itr1=this.getIterador();
		Iterator<Concursante> itr2=this.getIterador();
		Iterator<Concursante> itr3=this.getIterador();
		Concursante unConcursante;
		ListaConcursantes concursantesExpulsables=new ListaConcursantes();
		
		if (this.seCumplenLasReglas())
		{
			while(itr1.hasNext())
			{
				unConcursante=itr1.next();
				unConcursante.ponerACeroSusNominaciones();
			}
			
			while (itr2.hasNext())
			{
				unConcursante=itr2.next();
				unConcursante.aplicarNominaciones();
			}
			
			int umbral=this.calcularUmbral();
			System.out.print(umbral);
			
			while (itr3.hasNext())
			{
				unConcursante=itr3.next();
				if (unConcursante.cuantasNominacionesTiene()>=umbral)
				{
					concursantesExpulsables.anadir(unConcursante);
				}
			}
			
			return concursantesExpulsables;
		}
		else
		{
			System.out.print("No se cumplen las normas, y por tanto no se crea la lista de expulsables");
			return null;
		}
	}
	
	/**
	 * vacia el Roster de concursantes
	 */
	public void resetear()
	{
		this.lista = new ArrayList<Concursante>();
	}
}
