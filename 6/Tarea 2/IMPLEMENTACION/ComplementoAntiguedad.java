package org.pmoo.packlaboratorio6;

public class ComplementoAntiguedad extends ConceptoComplementos{

	private double numAnnos;
	
	public ComplementoAntiguedad(double pImporteBruto, double pNumAnnos) {
		super(pImporteBruto, 10);
		this.numAnnos=pNumAnnos;
	}

	
	public double obtenerImporte() {
		double importe=(super.getImporteBruto()*0.95-10)*(this.numAnnos/10);
		return importe;
	}

}
