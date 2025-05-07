package org.pmoo.packlaboratorio4;
import java.util.ArrayList;
import java.util.Iterator; 

public class ListaOperaciones
{
	// atributos
	private ArrayList<Operacion>lista;
	private static ListaOperaciones miLista;
	
	
	// constructora
	
	private ListaOperaciones()
	{ 
		this.lista= new ArrayList<Operacion>();
	}
	
	// otros metodos
	
  	public static ListaOperaciones getListaOperaciones()
	{
  		if (miLista==null)
		{
			miLista= new ListaOperaciones();
		}
		return miLista;
	}

  	private Iterator<Operacion> getIterador()
 	{
  		return this.lista.iterator();
 	}
 	
 	public int cantidadOperaciones()
 	{
 		return this.lista.size();
 	}

 	
 	public void anadirOperacion(int pIdOperacion, int pIdCliente, String pClaveTecleada, double pCantidad)
 	{
 		Operacion Operacion;
  		Boolean chivato=true;
  		Operacion annadir= new Operacion(pIdOperacion, pIdCliente, pClaveTecleada, pCantidad);
  		Iterator<Operacion> itr=this.getIterador();
  		while(itr.hasNext())
 	   {
 		   Operacion=itr.next();
 		   if (Operacion.tieneMismoId(pIdOperacion))
 		   {
 			   chivato=false;
 		   }
 	   }  		
  		if (chivato)
  		{
  			this.lista.add(annadir);  
  		}   
 	}

  	
 	public Operacion buscarOperacionPorId(int pId)
 	{
 	   Operacion Operacion=null;
 	   Boolean chivato=true;
 	   Iterator<Operacion> itr=this.getIterador();
 	   while(itr.hasNext())
 	   {
 		   Operacion=itr.next();
 		   if (Operacion.tieneMismoId(pId))
 		   {
 			   chivato=false;
 			   break;
 		   }
 	   }
 	   if (chivato)
 	   {
 		   Operacion=null;
 	   }
 	   return Operacion;
 	}

 	public void realizarOperaciones()
 	{
 		Operacion Operacion=null;
 		Iterator<Operacion> itr=this.getIterador();
 		while (itr.hasNext())
 		{
 			Operacion=itr.next();
 			Operacion.realizarOperacion();
 		}
 	}
 	
 	public void resetear()
 	{
 		this.lista.clear();
 	}
}	