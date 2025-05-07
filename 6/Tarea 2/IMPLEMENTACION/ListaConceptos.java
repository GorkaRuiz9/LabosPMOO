package org.pmoo.packlaboratorio6;
import java.util.ArrayList;
import java.util.Iterator;

import org.pmoo.packlaboratorio4.Operacion;

public class ListaConceptos {
	
	//Atributos
	private ArrayList<Concepto> lista;
	
	//Constructora
	public ListaConceptos()
	{
		this.lista=new ArrayList<Concepto>();
	}
	
	
	private Iterator<Concepto> getIterador()
 	{
  		return this.lista.iterator();
 	}
	
	public double obtenerSalario()
	{
		Concepto unConcepto;
		Iterator<Concepto> itr=this.getIterador();
		double valorUnConcepto=0;
		double valorTotal=0;
		
		while (itr.hasNext())
		{
			unConcepto=itr.next();
			
			if (unConcepto instanceof ConceptoLibre)
			{
				valorUnConcepto=((ConceptoLibre)unConcepto).obtenerImporte();
			}
			else if (unConcepto instanceof ConceptoSueldoBase)
			{
				valorUnConcepto=((ConceptoSueldoBase)unConcepto).obtenerImporte();
			}
			else if (unConcepto instanceof ConceptoExtras)
			{
				valorUnConcepto=((ConceptoExtras)unConcepto).obtenerImporte();
			}
			else if (unConcepto instanceof ComplementoDestino)
			{
				valorUnConcepto=((ComplementoDestino)unConcepto).obtenerImporte();
			}
			else if (unConcepto instanceof ComplementoCargo)
			{
				valorUnConcepto=((ComplementoCargo)unConcepto).obtenerImporte();
			}
			else if (unConcepto instanceof ComplementoAntiguedad)
			{
				valorUnConcepto=((ComplementoAntiguedad)unConcepto).obtenerImporte();
			}
			valorTotal=valorTotal+valorUnConcepto;
			
		}
		return valorTotal;
	}
	
	public void annadirConcepto(Concepto pConcepto)
	{
		this.lista.add(pConcepto);
	}
	
	public void limpiar()
	{
		this.lista.clear();
	}
	
}
