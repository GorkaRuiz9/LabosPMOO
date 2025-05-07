package org.pmoo.packlaboratorio4;

public class Operacion
{
	ListaClientes lista;
	
	// atributos
	private int idOperacion;
	private int idCliente;
	private String claveTecleada;
	private double cantidad;
	private static double comisionNoPref=0.1;
	
	
	
	// constructora
	   
	public Operacion(int pIdOper, int pIdCliente, String pClaveTecleada, double pCant)
	{
		this.idOperacion=pIdOper;
		this.idCliente=pIdCliente;
		this.claveTecleada=pClaveTecleada;
		this.cantidad=pCant;
		
	}
   
	public int getIdCliente() {
		return idCliente;
	}


	// otros metodos
	public boolean tieneMismoId(int pIdOperacion)
	{
		if (this.idOperacion==pIdOperacion)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
   
	public void realizarOperacion ()
	{
		double cantidadtotal=this.cantidad;
		lista=ListaClientes.getListaClientes();
		Cliente Cliente=lista.buscarClientePorId(idCliente);
		if (Cliente!=null)
		{
			Boolean pref=Cliente.esPreferente();
			if (!pref)
			{
				cantidadtotal=this.cantidad+this.comisionNoPref;
			}
			Cliente.actualizarSaldo(this.claveTecleada, cantidadtotal);
		}
	}
}
