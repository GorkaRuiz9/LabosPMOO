package org.pmoo.packlaboratorio1;

public class Coche 
{
	
	//Atributos
	private String matricula;
	private String marcaModelo;
	private Persona propietario;
	
	//Constructora
	public Coche (String pMatricula, String pMarcaModelo)
	{
		this.matricula=pMatricula;
		this.marcaModelo=pMarcaModelo;
	}
	
	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	//Métodos
	public boolean esElPropietario(Persona pPersona)
	{
		boolean rdo;
		rdo=false;
		if (this.propietario==pPersona)
		{
			rdo=true;
		}
		return rdo;
	}
	
	public boolean cambiarDePropietario (Persona pPersona)
	{
		boolean chivato;
		chivato=false;
		if (esElPropietario(pPersona)==false)
		{
			this.propietario=pPersona;
			chivato=true;
		}
		return chivato;
	}
}
