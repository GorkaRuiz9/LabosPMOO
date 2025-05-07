package org.pmoo.packlaboratorio6;

public class ConceptoSueldoBase extends Concepto {

	
	private int idSueldo;
	
	public ConceptoSueldoBase(float pImporteBruto, int pIdSueldo) 
	{
		super(pImporteBruto);
		this.idSueldo=pIdSueldo;
	}


	public double obtenerImporte()
	{
		double importe=super.getImporteBruto()*0.95;
		return importe;
		
	}
}
