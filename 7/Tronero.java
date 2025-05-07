package org.pmoo.packlaboratorio7;

public class Tronero extends Concursante
{
	// constructora
	public Tronero(String pNombre, int pPuntuacion)
	{
		super(pNombre, pPuntuacion);
	}

	// otros metodos
			
	/**
	 *  @return un booleano que indica si la lista de nominados del tronero cumple las reglas
	 *          definidas en el enunciado. Es decir: la puntuacion p del tronero debe ser mayor
	 *          o igual que cero, en su lista de nominados no puede haber mas de p concursantes,
	 *          y todos ellos deben ser troneros o pretendistas (esto es, no se pueden mezclar).           
	 *    
	 */
	@Override
	public boolean cumpleLasReglas()
	{
		boolean chivato=false;
		int contador=0;
		
		if ((super.numeroDePretendistasQueHaNominado()+super.numeroDeTronerosQueHaNominado())<=super.obtenerPuntuacion())
			{
			if ((super.numeroDePretendistasQueHaNominado()>=0 && super.numeroDeTronerosQueHaNominado()==0) || (super.numeroDePretendistasQueHaNominado()==0 && super.numeroDeTronerosQueHaNominado()>=0))
				{
					chivato=true;
				}
			}
		
		if (super.obtenerPuntuacion()<0)
		{
			chivato=false;
		}

		while (contador<(super.numeroDePretendistasQueHaNominado()+super.numeroDeTronerosQueHaNominado()))
		{
			Concursante unConcursante=super.obtenerListaNominados().obtenerConcursanteEnPos(contador);
			contador=contador+1;
			if (unConcursante.obtenerPuntuacion()<0)
			{
				chivato=false;
			}
		}
		return chivato;
	}

	
	/**
	 *  @param pConcursanteNominado
	 *   post: se incrementa el numero de nominaciones de pConcursanteNominado en 2, dado que las 
	 *         nominaciones de un Tronero siempre penalizan doble. 
	 */
	@Override
	protected void aplicarNominacion(Concursante pConcursanteNominado)
	{
		pConcursanteNominado.incrementarNominacionesRecibidas(2);
	}

	
	/**
	 *  @param pPretendista
	 *  @return un booleano que indica si pPretendista se encuentra en la lista de nominados
	 *          del tronero actual.    
	 */
	public boolean estaEntreSusNominados(Pretendista pPretendista)
	{
		return this.obtenerListaNominados().esta(pPretendista);
	}

}
