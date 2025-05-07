package org.pmoo.packlaboratorio6;

abstract class Concepto {

	//Atributos
	private double importeBruto;
	
	//Constructora
	protected Concepto(double pImporteBruto)
	{
		this.importeBruto=pImporteBruto;
	}

	public abstract double obtenerImporte();
	
	
	public double getImporteBruto() {
		return importeBruto;
	}



	
}
