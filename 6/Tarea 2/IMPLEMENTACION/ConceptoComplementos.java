package org.pmoo.packlaboratorio6;

abstract class ConceptoComplementos extends Concepto{

	private static double impuesto;
	
	protected ConceptoComplementos(double pImporteBruto, double pImpuesto) 
	{
		super(pImporteBruto);
		this.impuesto=pImpuesto;
	}
	
	
}
