package org.pmoo.packlaboratorio4;
import java.util.ArrayList;
import java.util.Iterator; 

public class ListaClientes
{
	// atributos
	private ArrayList<Cliente>lista;
	private static ListaClientes miLista;
	
	
	// constructora
	
	private ListaClientes()
	{ 
		this.lista=new ArrayList<Cliente>();
	}
	
	// otros metodos
	
	public static ListaClientes getListaClientes()
  	{
		if (miLista==null)
		{
			miLista= new ListaClientes();
		}
		return miLista;
	}

 	private Iterator<Cliente> getIterador()
 	{
 		return this.lista.iterator();
 	}

 	public int cantidadClientes()
 	{
 		return this.lista.size();
 	}
 	
  	public void anadirCliente(int pIdCliente, String pNombre, String pClave, double pSaldo, boolean pEsPreferente)
 	{	
  		Cliente Cliente;
  		Boolean chivato=true;
  		Cliente annadir= new Cliente(pIdCliente, pNombre, pClave, pSaldo, pEsPreferente);
  		Iterator<Cliente> itr=this.getIterador();
 	   while(itr.hasNext())
 	   {
 		   Cliente=itr.next();
 		   if (Cliente.tieneMismoId(pIdCliente))
 		   {
 			   chivato=false;
 		   }
 	   }  		
  		if (chivato)
  		{
  			this.lista.add(annadir);  
  		}
 	}
 
	public Cliente buscarClientePorId(int pId)
 	{
	   Cliente Cliente=null;
	   Boolean chivato=true;
	   Iterator<Cliente> itr=this.getIterador();
	   while(itr.hasNext())
	   {
		   Cliente=itr.next();
		   if (Cliente.tieneMismoId(pId))
		   {
			   chivato=false;
			   break;
		   }
	   }
	   if (chivato)
	   {
		   Cliente=null;
	   }
	   return Cliente;
 	}
  	
  	public void resetear()
 	{
 		this.lista.clear();
 	}
}	