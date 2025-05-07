package org.pmoo.packlaboratorio6;

public class ComplementoCargo extends ConceptoComplementos{

	private String desc;
	
	public ComplementoCargo(double pImporteBruto, String pDesc) 
	{
		super(pImporteBruto, 20);
		this.desc=pDesc;
	}

	
	public double obtenerImporte() {
		double importe=super.getImporteBruto()*0.95-20;
		return importe;
	}

}
