package org.pmoo.packlaboratorio7;

public class Pretendista extends Concursante
{
	// constructora
	public Pretendista(String pNombre, int pPuntuacion)
	{
		super(pNombre,pPuntuacion);
	}

	/**
	 *  @return un booleano que indica si la lista de nominados del pretendista cumple las reglas
	 *          definidas en el enunciado. Es decir: la puntuacion p del pretendista debe ser mayor
	 *          o igual que cero, y en su lista de nominados no puede haber mas de p pretendistas,
	 *          ni mas de un tronero.          
	 *    
	 */
	@Override
	public boolean cumpleLasReglas()
	{
		boolean chivato=false;
		int contador=0;
		
			if (super.numeroDePretendistasQueHaNominado()<=super.obtenerPuntuacion() && super.numeroDeTronerosQueHaNominado()<=1)
			{
				chivato=true;
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
	 *   post: se incrementa el numero de nominaciones de pConcursanteNominado en 1 o en 5, dependiendo de 
	 *         la situacion: si pConcursanteNominado es un pretendista o un tronero que no ha nominado al 
	 *         concursante actual, se incrementa en 1 (nominacion normal), pero si pConcursanteNominado es
	 *         un tronero que a su vez ha nominado al pretendista actual, entonces se incrementa el numero
	 *         de nominaciones recibidas por pConcursanteNominado en 5 (nominacion quintuple).
	 */
	@Override
	protected void aplicarNominacion(Concursante pConcursanteNominado)
	{
		if (pConcursanteNominado instanceof Tronero && ((Tronero) pConcursanteNominado).estaEntreSusNominados(this))
		{
			pConcursanteNominado.incrementarNominacionesRecibidas(5);
		}
		else
		{
		pConcursanteNominado.incrementarNominacionesRecibidas(1);
		}
	}
}
