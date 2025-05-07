package org.pmoo.packlaboratorio6;

public class Empleado {

	
	//Atributos
	private int identificador;
	private String nombre;
	private String apellido;
	private ListaConceptos lista;
	
	//Constructora
	public Empleado (int pId, String pNombre, String pApellido, ListaConceptos pLista)
	{
		this.identificador=pId;
		this.nombre=pNombre;
		this.apellido=pApellido;
		this.lista=pLista;
	}
	
	public double obtenerSalario()
	{
		return this.lista.obtenerSalario();
	}
}
