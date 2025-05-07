package org.pmoo.packlaboratorio4;

public class Cliente
{
	// atributos
	private int idCliente;
	private String nombre;
	private String clave;
	private double saldo;
	private boolean esPreferente;
	
	
	
	// constructora	
	
	public Cliente(int pId, String pNombre, String pClave,
			double pSaldo, boolean pPref)
	{
		this.idCliente=pId;
		this.nombre=pNombre;
		this.clave=pClave;
		this.saldo=pSaldo;
		this.esPreferente=pPref;
	}

   // otros metodos
   
	public String getNombre() {
		return nombre;
	}

	public boolean esPreferente()
	{
	   return this.esPreferente;
	}
   
	public boolean tieneMismoId(int pId)
	{
	   if (this.idCliente==pId)
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
	}
   
	public double obtenerSaldo(String pClaveTecleada)
	{
	   if (this.comprobarClave(pClaveTecleada))
	   {
		return this.saldo;
	   }
	   else
	   {
		   return 0.0;
	   }
	}
   
	private boolean comprobarClave(String pClave)
	{
		if (this.clave==pClave)
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
	}
   
	public void actualizarSaldo(String pClaveTecleada, double pCantidad)
	{
	   if (this.comprobarClave(pClaveTecleada))
	   {
		   if (this.saldo<pCantidad || pCantidad<0)
		   {
			   System.out.print("No se puede llevar a cabo la transacción, debido a que la cantidad a retirar es negativa o el saldo es menor a esa cantidad");
		   }
		   else
		   {
			   this.saldo=this.saldo-pCantidad;
			   System.out.print(this.nombre);
			   System.out.print(this.saldo);
		   }
	   }
	   else
	   {
		   System.out.print("No se ha actualizado el saldo ya que la clave es incorrecta");
	   }
	}
}