package org.pmoo.packlaboratorio6;

public class ComplementoDestino extends ConceptoComplementos{
	
	private String ciudad;
	private String sucursal;
	
	public ComplementoDestino(double pImporteBruto, String pCiudad, String pSucursal) {
		super(pImporteBruto, 50);
		this.ciudad=pCiudad;
		this.sucursal=pSucursal;
	}

	
	public double obtenerImporte() {
		double importe=super.getImporteBruto()*0.95-50;
		return importe;
	}

}
