package org.pmoo.packlaboratorio6;

public class ConceptoLibre extends Concepto {

	private String descTrabajo;
	private double numHoras;
	
	public ConceptoLibre(float pImporteBruto, String pDescTrabajo, double pNumHoras) 
	{
		super(pImporteBruto);
		this.descTrabajo=pDescTrabajo;
		this.numHoras=pNumHoras;
	}

	public double obtenerImporte()
	{
		double importe=super.getImporteBruto()*this.numHoras;
		return importe;
	}
}
