package org.pmoo.packlaboratorio8;


public class Participante 
{
	private String nombre;
	private int id;
	private int edad;

	/**
	 * 
	 * @param pNombre
	 * @param pId
	 * @param pEdad
	 *            
	 * @exception se lanza una MenorDeEdadException si pEdad es menor de 18.
	 *            Si no, se inicializa un nuevo objeto de la clase Participante con nombre pNombre,
	 *            identificador pId, y edad pEdad
	 * 
	 * 
	 */
	public Participante(String pNombre, int pId, int pEdad) throws MenorDeEdadException
	{
		if (pEdad<18)
		{
			throw (new MenorDeEdadException());
		}
		
		this.nombre=pNombre;
		this.id=pId;
		this.edad=pEdad;
	}
	
	
	
	/**
	 * 
	 * @param pId
	 * @return un booleano que indica si el identificador del participante es igual a pId.
	 * 
	 */
	public boolean tieneEsteId(int pId) 
	{
		if (this.id==pId)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	
	/**
	 * 
	 * @return el nombre del participante.
	 * 
	 */
	public String obtenerNombre() 
	{
		return this.nombre;
	}
	

	
	/**
	 * 
	 * @return la edad del participante.
	 * 
	 */
	public int obtenerEdad() 
	{
		return this.edad;
	}


	
}
