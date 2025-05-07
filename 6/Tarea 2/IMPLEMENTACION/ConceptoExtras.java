package org.pmoo.packlaboratorio6;

public class ConceptoExtras extends Concepto {

	private double hoExtraordinarias;
	private double precioHora;
	private String justificacion;
	
	
	
	public ConceptoExtras(float pImporteBruto, double pHoExtraordinarias, double pPrecioHora, String pJustificacion) {
		super(pImporteBruto);
		this.hoExtraordinarias=pHoExtraordinarias;
		this.precioHora=pPrecioHora;
		this.justificacion=pJustificacion;
	}


	public double obtenerImporte() {
		double importe=super.getImporteBruto()*0.9+this.hoExtraordinarias*this.precioHora;
		return importe;
	}
	

}
