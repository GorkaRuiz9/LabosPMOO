package org.pmoo.packlaboratorio1;

public class Persona 
{
	//Atributos
	
	private String nombreCompleto;
	private int edad;
	private int idPersona;
	private String grupoSanguineo;
	private String nacionalidad;
	
	//Constructora
	
	public Persona(String pNombreCompleto, int pEdad) 
	{
		this.nombreCompleto = pNombreCompleto;
		this.edad = pEdad;
	}
	
	public Persona(String pNombreCompleto, int edad, int pIdPersona, String pGrupoSanguineo, String pNacionalidad) 
	{
		this.nombreCompleto = pNombreCompleto;
		this.edad = edad;
		this.idPersona = pIdPersona;
		this.grupoSanguineo = pGrupoSanguineo;
		this.nacionalidad = pNacionalidad;
	}

	
	//Getters / Setters
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	//Métodos
	
	public boolean tieneMismoID (Persona pPersona)
	{
		boolean rdo;
		
			if (idPersona==pPersona.idPersona)
			{
				rdo=true;
			}
			else
			{
				rdo=false;
			}
		
		return rdo;
		
	}
	
	public boolean puedeConducir ()
	{
		boolean rdo;
		rdo=false;
		if (this.nacionalidad=="Etíope")
		{
			if (this.edad>13)
				{
				rdo=true;
				}
		}
		else if (this.nacionalidad=="Australiana" || this.nacionalidad=="Estadounidense")
			{
			if (this.edad>15)
				{
				rdo=true;
				}
			}
		else if (this.nacionalidad=="Británica")
			{
			if (this.edad>16)
				{
				rdo=true;
				}
			}
		else
		{
			if (this.edad>17)
			{
				rdo=true;
			}
		}
	return rdo;
	}
	
	
	public char inicialNombre ()
	{
		char inicial;
		inicial=this.nombreCompleto.charAt(0);
		return inicial;
	}
	
	
	public char inicialApellido()
	{
		char inicial;
		inicial=' ';
		for (int i=this.nombreCompleto.length()-1;i>=0; i=i-1)
		{
			if (this.nombreCompleto.charAt(i-1)==' ')
				{
					inicial=this.nombreCompleto.charAt(i);	
				}
		}
		return inicial;
	}


	public boolean puedeDonarleSangre (Persona pPersona)
	{
		boolean rdo;
		rdo=false;
		if (pPersona.grupoSanguineo=="0+" && (this.grupoSanguineo=="0+" || this.grupoSanguineo=="0-"))
		{
			rdo=true;
		}
		else if (pPersona.grupoSanguineo=="0-" && this.grupoSanguineo=="0-")
		{
			rdo=true;
		}
		else if (pPersona.grupoSanguineo=="A+" && (this.grupoSanguineo=="0+" || this.grupoSanguineo=="0-" || this.grupoSanguineo=="A+" || this.grupoSanguineo=="A-"))
		{
			rdo=true;
		}
		else if (pPersona.grupoSanguineo=="A-" && (this.grupoSanguineo=="A-" || this.grupoSanguineo=="0-"))
		{
			rdo=true;
		}
		else if (pPersona.grupoSanguineo=="B+" && (this.grupoSanguineo=="0+" || this.grupoSanguineo=="0-" || this.grupoSanguineo=="B+" || this.grupoSanguineo=="B-"))
		{
			rdo=true;
		}
		else if (pPersona.grupoSanguineo=="B-" && (this.grupoSanguineo=="B-" || this.grupoSanguineo=="0-"))
		{
			rdo=true;
		}
		else if (pPersona.grupoSanguineo=="AB+")
		{
			rdo=true;
		}
		else if (pPersona.grupoSanguineo=="AB-" && (this.grupoSanguineo=="A-" || this.grupoSanguineo=="0-" || this.grupoSanguineo=="B-" || this.grupoSanguineo=="AB-"))
		{
			rdo=true;
		}
		return rdo;
	}
	

}